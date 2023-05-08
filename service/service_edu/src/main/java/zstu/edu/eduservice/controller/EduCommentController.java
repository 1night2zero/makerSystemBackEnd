package zstu.edu.eduservice.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zstu.edu.commonutils.R;
import zstu.edu.eduservice.entity.EduComment;
import zstu.edu.eduservice.service.EduCommentService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 评论 也是放在前端课程查询中
 * </p>
 *
 * @author mier
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/eduservice/educomment")
@CrossOrigin
public class EduCommentController {
    //分页课程查询功能
    @Autowired
    private EduCommentService commentService;

    //分页查询评论
    @GetMapping("getComment/{courseId}/{current}/{limit}")
    public R getComment(@PathVariable("courseId") String courseId,
                        @PathVariable("current") Long current,
                        @PathVariable("limit") Long limit) {
        Page<EduComment> page = new Page<>(current, limit);
        QueryWrapper<EduComment> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);//根据课程id进行查询
        wrapper.orderByDesc("gmt_create");//按降序排列

        Map<String, Object> map = commentService.getCommentPage(page, wrapper);

        return R.ok().data((HashMap<String, Object>) map);
    }

    //添加评论 将评论存入数据库中
    @PostMapping("save")
    public R save(@RequestBody EduComment comment, HttpServletRequest request) {
        System.out.println(comment);
        return commentService.saveComment(comment, request);
    }
}

