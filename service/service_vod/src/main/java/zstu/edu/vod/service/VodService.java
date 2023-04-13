package zstu.edu.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VodService {

    String uploadVideoAly(MultipartFile file);

    String getPlayUrl(String videoId);

    void removeVideo(String id);

    // 删除多个视频
    void removeAlyVideoList(List<String> videoIdList);
}
