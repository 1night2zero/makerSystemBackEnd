package zstu.edu.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface VodService {

    String uploadVideoAly(MultipartFile file);

    String getPlayUrl(String videoId);

    void removeVideo(String id);
}
