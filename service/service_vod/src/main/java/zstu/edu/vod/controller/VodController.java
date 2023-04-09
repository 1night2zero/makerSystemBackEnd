package zstu.edu.vod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import zstu.edu.commonutils.R;
import zstu.edu.vod.service.VodService;

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
}
