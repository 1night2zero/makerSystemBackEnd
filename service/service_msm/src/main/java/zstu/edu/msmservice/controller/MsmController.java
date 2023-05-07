package zstu.edu.msmservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zstu.edu.commonutils.R;
import zstu.edu.commonutils.RandomUtil;
import zstu.edu.msmservice.service.MsmService;

import java.util.concurrent.TimeUnit;

@RestController
//@CrossOrigin
@RequestMapping("/edumsm/msm")
public class MsmController {

    @Autowired
    MsmService msmService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // 发送验证码 默认五分钟有效
    @GetMapping(value = "/send/{phone}")
    public R code(@PathVariable String phone) {
        // 1. redis中有验证码说明验证码五分钟还没有失效，直接返回ok
        String code = redisTemplate.opsForValue().get(phone);
        System.out.println(code);
        if (!StringUtils.isEmpty(code)) {
            return R.ok().data("code", code);
        }
        // 2. 否则说明验证码失效，生成随机的六位验证码
        code = RandomUtil.getSixBitRandom();
        // Map<String,Object> param = new HashMap<>();
        // param.put("code", code);
        boolean isSend = msmService.send(phone, code);
        if (isSend) {
            // 发送成功，在redis中设置验证码为五分钟有效
            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);
            return R.ok().data("code", code);
        } else {
            return R.error().message("发送短信失败");
        }
    }

    //发送邮箱验证码的方法
    @GetMapping("send/{mailAdress}")
    public R sendMsm(@PathVariable("mailAdress") String mailAdress) {
        //1 从redis获取验证码，如果获取到 直接返回
        String code = redisTemplate.opsForValue().get(mailAdress);
        if (!StringUtils.isEmpty(code)) {
            return R.ok();
        }
        //2 如果redis获取不到，进行阿里云发送
        //生成随机值 传递阿里云进行发送
        code = RandomUtil.getSixBitRandom();
        //调用service发短信息的方法
        boolean isSend = msmService.send(code, mailAdress);
        if (isSend) {
            //发送成功，把发送成功验证码放到redis里面
            redisTemplate.opsForValue().set(mailAdress, code, 5, TimeUnit.MINUTES);
            //设置有效时间
            return R.ok();
        } else {
            return R.error().message("邮件发送失败");
        }

    }
}
