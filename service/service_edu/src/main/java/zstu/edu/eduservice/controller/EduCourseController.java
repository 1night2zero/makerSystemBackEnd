package zstu.edu.eduservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import zstu.edu.commonutils.R;
import zstu.edu.eduservice.entity.vo.CourseInfoVo;
import zstu.edu.eduservice.service.EduCourseService;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author mier
 * @since 2023-03-12
 */
@RestController
@RequestMapping("/eduservice/edu-course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    EduCourseService eduCourseService;

    // 添加课程基本信息的方法
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        eduCourseService.saveCourseInfo(courseInfoVo);
        return R.ok();
    }
}

