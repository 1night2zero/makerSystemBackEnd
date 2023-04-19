package zstu.edu.eduservice.service;

import zstu.edu.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import zstu.edu.eduservice.entity.vo.CourseInfoVo;
import zstu.edu.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author mier
 * @since 2023-03-12
 */
public interface EduCourseService extends IService<EduCourse> {

    // 添加课程基本信息的方法
    String saveCourseInfo(CourseInfoVo courseInfoVo);

    // 根据课程id查询课程基本信息
    CourseInfoVo getCourseInfo(String courseId);

    // 修改课程信息
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    // 根据课程id查询课程确认信息
    CoursePublishVo getPublishCourseInfo(String id);

    // 删除课程
    void removeCourse(String courseId);
}
