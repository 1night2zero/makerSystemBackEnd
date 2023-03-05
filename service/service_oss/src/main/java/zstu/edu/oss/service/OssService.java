package zstu.edu.oss.service;

import org.jacoco.agent.rt.internal_1f1cc91.core.runtime.AgentOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface OssService {

    // 上传头像到oss
    String uploadFileAvatar(MultipartFile file);
}
