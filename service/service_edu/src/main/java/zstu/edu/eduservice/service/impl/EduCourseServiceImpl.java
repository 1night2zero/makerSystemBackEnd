package zstu.edu.eduservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import zstu.edu.eduservice.entity.EduCourse;
import zstu.edu.eduservice.entity.EduCourseDescription;
import zstu.edu.eduservice.entity.vo.CourseInfoVo;
import zstu.edu.eduservice.mapper.EduCourseMapper;
import zstu.edu.eduservice.service.EduCourseDescriptionService;
import zstu.edu.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zstu.edu.servicebase.exceptionhandler.MyException;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author mier
 * @since 2023-03-12
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    @Override
    public void saveCourseInfo(CourseInfoVo courseInfoVo) {
        // 向课程表添加课程基本信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if (insert == 0) {
            throw new MyException(20001, "添加课程信息失败");
        }
        String cid = eduCourse.getId();
        // 向课程简介表添加课程简介
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(cid);
        courseDescriptionService.save(courseDescription);
    }
}
