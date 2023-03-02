package zstu.edu.eduservice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import zstu.edu.commonutils.R;
import zstu.edu.eduservice.entity.EduTeacher;
import zstu.edu.eduservice.service.EduTeacherService;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author mier
 * @since 2023-03-01
 */

// 定义接口说明和参数说明
// 定义在类上：@Api
// 定义在方法上：@ApiOperation
// 定义在参数上：@ApiParam

@RestController
@RequestMapping("/eduservice/edu-teacher")
@Api(description = "讲师管理")
public class EduTeacherController {
    /* localhost:8001 */
    @Autowired
    private EduTeacherService teacherService;

    // 查询所有老师
    @ApiOperation(value = "查询所有老师列表")
    @GetMapping("findAll")
    public R findAllTeacher() {
        List<EduTeacher> list = teacherService.list(null);

        return R.ok().data("items", list);
    }

    // 逻辑删除讲师
    @DeleteMapping("delete/{id}")
    public R removeTeacher(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id) { // 获取路径中的id
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();

        }
    }

}

