package zstu.edu.eduservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import zstu.edu.eduservice.entity.EduTeacher;
import zstu.edu.eduservice.service.EduTeacherService;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2023-03-01
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    /* localhost:8001 */
    @Autowired
    private EduTeacherService teacherService;

    // 查询所有老师
    @GetMapping("findAll")
    public List<EduTeacher> findAllTeacher() {
        return teacherService.list(null);
    }


}

