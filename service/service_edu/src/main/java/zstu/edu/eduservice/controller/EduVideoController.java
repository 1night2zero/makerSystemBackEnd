package zstu.edu.eduservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import zstu.edu.commonutils.R;
import zstu.edu.eduservice.client.VodClient;
import zstu.edu.eduservice.entity.EduVideo;
import zstu.edu.eduservice.service.EduVideoService;
import zstu.edu.servicebase.exceptionhandler.MyException;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author mier
 * @since 2023-03-12
 */
@RestController
@RequestMapping("/eduservice/edu-video")
@CrossOrigin
public class EduVideoController {

    @Autowired
    private VodClient vodClient;

    @Autowired
    private EduVideoService eduVideoService;

    // 添加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        eduVideoService.save(eduVideo);
        return R.ok();
    }

    // 删除小节
    // 后面要删除小节里面的视频
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id) {
        // 根据小节id获取到视频id
        EduVideo eduVideo = eduVideoService.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();
        // 判断小节是否有id
        if (!StringUtils.isEmpty(videoSourceId)) {
            // 根据视频id远程调用方法删除视频
            R result = vodClient.removeAlyVideo(videoSourceId);
            if (result.getCode() == 20001) {
                throw new MyException(20001, "删除视频失败，熔断器...");
            }
        }
        // 删除小节
        eduVideoService.removeById(id);
        return R.ok();
    }

    // 修改小节
    @PostMapping("updateVideo")
    public R updateVideo(@RequestBody EduVideo eduVideo) {
        eduVideoService.updateById(eduVideo);
        return R.ok();
    }

    // 根据id查询小节
    @GetMapping("getVideoInfo/{videoId}")
    public R getVideoInfo(@PathVariable String videoId) {
        EduVideo eduVideo = eduVideoService.getById(videoId);
        return R.ok().data("video", eduVideo);
    }
}

