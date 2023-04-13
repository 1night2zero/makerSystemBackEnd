package zstu.edu.eduservice.client;

import org.springframework.stereotype.Component;
import zstu.edu.commonutils.R;

import java.util.List;

@Component
public class VodFileDegradeFeignClient implements VodClient {
    @Override
    public R removeAlyVideo(String id) {
        System.out.println("删除视频出错了");
        return null;
    }

    @Override
    public R deleteBatch(List<String> videoIdList) {
        return null;
    }
}
