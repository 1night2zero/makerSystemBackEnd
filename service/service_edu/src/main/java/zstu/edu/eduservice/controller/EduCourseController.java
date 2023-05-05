package zstu.edu.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import zstu.edu.commonutils.R;
import zstu.edu.eduservice.entity.EduCourse;
import zstu.edu.eduservice.entity.vo.CourseInfoVo;
import zstu.edu.eduservice.entity.vo.CoursePublishVo;
import zstu.edu.eduservice.service.EduCourseService;

import java.util.List;

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
        String id = eduCourseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId", id);
    }

    // 根据课程id查询课程基本信息
    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = eduCourseService.getCourseInfo(courseId);
        return R.ok().data("courseInfoVo", courseInfoVo);
    }

    // 修改课程信息
    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        eduCourseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    // 根据课程id查询课程确认信息
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id) {
        CoursePublishVo publishCourseInfo = eduCourseService.getPublishCourseInfo(id);
        System.out.println(publishCourseInfo);
        return R.ok().data("publishCourse", publishCourseInfo);
    }

    // 课程最终发布
    // 修改课程状态
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus(EduCourse.STATUS_NORMAL);
        eduCourseService.updateById(eduCourse);
        return R.ok();
    }

    // 查询课程列表
    // TODO 条件查询带分页
    @GetMapping("getCourseList")
    public R getCourseList() {
        // 已发布的课程优先显示，按Status排序
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("status");
        List<EduCourse> list = eduCourseService.list(wrapper);
        return R.ok().data("list", list);
    }

    // 根据id删除课程
    @DeleteMapping("removeCourse/{courseId}")
    public R removeCourse(@PathVariable String courseId) {
        eduCourseService.removeCourse(courseId);
        return R.ok();
    }

    // 获取热门课程
    @GetMapping("getTopCourses")
    public R getTopCourses() {
        List<EduCourse> list = eduCourseService.getTopCourses(6);
        return R.ok().data("list", list);
    }
}

