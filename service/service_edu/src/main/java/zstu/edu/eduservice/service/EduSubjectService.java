package zstu.edu.eduservice.service;

import org.springframework.web.multipart.MultipartFile;
import zstu.edu.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author mier
 * @since 2023-03-06
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file, EduSubjectService eduSubjectService);
}
