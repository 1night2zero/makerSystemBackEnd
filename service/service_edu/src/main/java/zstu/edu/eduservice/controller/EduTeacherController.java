package zstu.edu.eduservice.controller;


import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import zstu.edu.commonutils.R;
import zstu.edu.eduservice.entity.EduTeacher;
import zstu.edu.eduservice.entity.vo.TeacherQuery;
import zstu.edu.eduservice.service.EduTeacherService;
import zstu.edu.servicebase.exceptionhandler.MyException;

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
@CrossOrigin
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

    // 添加讲师
    @ApiOperation(value = "添加讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = teacherService.save(eduTeacher);
        if (save) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    // 逻辑删除讲师
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("deleteTeacher/{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)
                           @PathVariable String id) { // 获取路径中的id
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();

        }
    }

    // 根据讲师id查询
    @ApiOperation(value = "根据讲师id查询")
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id) {
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data("teacher", eduTeacher);
    }

    // 讲师修改
    @ApiOperation(value = "讲师修改")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = teacherService.updateById(eduTeacher);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    // 分页查询讲师
    @ApiOperation(value = "分页查询讲师")
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable Long current,    // 当前页
                             @PathVariable Long limit) {    // 每页记录数
        Page<EduTeacher> teacherPage = new Page<>(current, limit);
        teacherService.page(teacherPage, null);
        long total = teacherPage.getTotal();    // 总记录数
        List<EduTeacher> records = teacherPage.getRecords();    // 数据集合
        return R.ok().data("total", total).data("rows", records);
    }

    // 条件查询带分页
    @ApiOperation(value = "条件查询带分页")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(/*@ApiParam(name = "current", value = "当前页", required = true)*/
            @PathVariable long current,
            @PathVariable long limit,
            @RequestBody(required = false) TeacherQuery teacherQuery) {
        // 创建page对象
        Page<EduTeacher> teacherPage = new Page<>(current, limit);
        // 构造条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        // 多条件组合查询 动态sql
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        //排序
        wrapper.orderBy(true, false, "gmt_create");

        // 判断条件值是否为空，如果不为空拼接条件
        if (!StringUtils.isEmpty(name)) {
            // 构造条件
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_modified", end);
        }

        teacherService.page(teacherPage, wrapper);

        long total = teacherPage.getTotal();    // 总记录数
        List<EduTeacher> records = teacherPage.getRecords();    // 数据集合

        return R.ok().data("total", total).data("rows", records);
    }

}

