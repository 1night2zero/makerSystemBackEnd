package zstu.edu.eduservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zstu.edu.commonutils.R;

@FeignClient("service-vod")
@Component
public interface VodClient {



    // 定义调用方法路径
     @DeleteMapping("/edu-vod/video/removeAlyVideo/{id}")
    public R removeAlyVideo(@PathVariable("id") String id);

}
