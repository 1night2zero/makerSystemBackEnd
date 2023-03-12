package zstu.edu.eduservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import zstu.edu.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import zstu.edu.eduservice.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author mier
 * @since 2023-03-12
 */
public interface EduCourseService extends IService<EduCourse> {

    void saveCourseInfo(CourseInfoVo courseInfoVo);
}
