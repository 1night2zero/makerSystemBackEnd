package zstu.edu.eduservice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import zstu.edu.commonutils.R;
import zstu.edu.eduservice.entity.subject.FirstSubject;
import zstu.edu.eduservice.service.EduSubjectService;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author mier
 * @since 2023-03-06
 */
@RestController
@RequestMapping("/eduservice/edu-subject")
@CrossOrigin
@Api(description = "课程分类管理")
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;

    // 添加课程分类
    // 获取上传过来的文件，把文件内容读取出来
    @ApiOperation(value = "Excel批量导入")
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file) {
        // 上传过来的excel文件
        eduSubjectService.saveSubject(file, eduSubjectService);
        return R.ok();
    }

    // 课程分类列表（树形）
    @ApiOperation(value = "课程分类列表（树形）")
    @GetMapping("getAllSubject")
    public R getAllSubject() {
        // list集合泛型是一级分类
        List<FirstSubject> list = eduSubjectService.getAllOneTwoSubject();
        return R.ok().data("list", list);
    }
}

