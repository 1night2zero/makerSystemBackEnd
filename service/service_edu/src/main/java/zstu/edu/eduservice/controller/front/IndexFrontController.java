package zstu.edu.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zstu.edu.commonutils.R;
import zstu.edu.eduservice.entity.EduCourse;
import zstu.edu.eduservice.entity.EduTeacher;
import zstu.edu.eduservice.service.EduCourseService;
import zstu.edu.eduservice.service.EduTeacherService;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/eduservice/indexfront")
public class IndexFrontController {

    @Autowired
    private EduCourseService courseService;
    @Autowired
    private EduTeacherService teacherService;

    // 查询前八条热门课程 和 四个名师
    // key双引号里面再加一个单引号
    @Cacheable(key = "'index'", value = "hotData") // 缓存
    @GetMapping("/index")
    public R index() {
        QueryWrapper<EduCourse> CourseWrapper = new QueryWrapper<>();
        CourseWrapper.orderByDesc("id").last("limit 8");
        List<EduCourse> courses = courseService.list(CourseWrapper);

        QueryWrapper<EduTeacher> teacherWrapper = new QueryWrapper<>();
        teacherWrapper.orderByDesc("id").last("limit 4");
        List<EduTeacher> teachers = teacherService.list(teacherWrapper);
        return R.ok().data("eduList", courses).data("teacherList", teachers);
    }

}
