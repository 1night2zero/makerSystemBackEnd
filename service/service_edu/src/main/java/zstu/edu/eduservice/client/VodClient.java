package zstu.edu.eduservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import zstu.edu.commonutils.R;

import java.util.List;

@FeignClient("service-vod")
@Component
public interface VodClient {


    // 调用删除视频方法路径
    @DeleteMapping("/edu-vod/video/removeAlyVideo/{id}")
    public R removeAlyVideo(@PathVariable("id") String id);

    // 调用删除多个视频的方法
    @DeleteMapping("/edu-vod/video/delete-batch")
    public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList);

}
