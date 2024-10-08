package zstu.edu.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import zstu.edu.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2023-03-01
 */
public interface EduTeacherService extends IService<EduTeacher> {
    Map<String, Object> getTeacherFrontList(Page<EduTeacher> teacherPage);
}
