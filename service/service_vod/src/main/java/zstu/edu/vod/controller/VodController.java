package zstu.edu.vod.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zstu.edu.commonutils.R;
import zstu.edu.servicebase.exceptionhandler.MyException;
import zstu.edu.vod.service.VodService;
import zstu.edu.vod.utils.ConstantVodUtils;
import zstu.edu.vod.utils.InitVodClient;

@RestController
@RequestMapping("/edu-vod/video")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    // 上传视频到阿里云
    @PostMapping("uploadAlyVideo")
    public R uploadAlyVideo(MultipartFile file) {
        String videoId = vodService.uploadVideoAly(file);

        // 返回上传视频id
        return R.ok().data("videoId", videoId);
    }

    // getPlayUrl by id
    @PostMapping("getPlayAuth/{videoId}")
    public R getPlayAuth(@PathVariable String videoId) {
        String playAuth = vodService.getPlayUrl(videoId);
        return R.ok().data("playAuth", playAuth);
    }

    // 根据视频id删除阿里云视频
    @DeleteMapping("removeAlyVideo/{id}")
    public R removeAlyVideo(@PathVariable String id) {
        vodService.removeVideo(id);
        return R.ok();
    }
}
