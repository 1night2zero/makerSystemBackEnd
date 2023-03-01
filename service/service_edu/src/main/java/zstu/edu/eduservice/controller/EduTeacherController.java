package zstu.edu.eduservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // 逻辑删除讲师
    @DeleteMapping("delete/{id}")
    public boolean removeTeacher(@PathVariable String id) { // 获取路径中的id
        return teacherService.removeById(id);
    }

}

