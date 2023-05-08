package zstu.edu.forumservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zstu.edu.commonutils.R;
import zstu.edu.forumservice.entity.ForumComment;
import zstu.edu.forumservice.service.ForumCommentService;

/**
 * <p>
 * 论坛评论表 前端控制器
 * </p>
 *
 * @author mier
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/forumservice/forum-comment")
public class ForumCommentController {


    @Autowired
    private ForumCommentService forumCategoryService;

    //论坛评论表
    @PostMapping("addForumComment")
    public R addForumComment(@RequestBody ForumComment forumComment) {
        forumCategoryService.save(forumComment);
        return R.ok();
    }

    //用户删除论坛评论
    @ApiOperation(value = "删除ForumComment")
    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id) {
        forumCategoryService.removeById(id);
        return R.ok();
    }

    //用户修改论坛评论
    @ApiOperation(value = "修改ForumComment")
    @PutMapping("update")
    public R updateById(@RequestBody ForumComment ForumComment) {
        forumCategoryService.updateById(ForumComment);
        return R.ok();
    }

    //用户查看论坛评论
    //用户查看论坛评论详情
    @ApiOperation(value = "获取ForumComment")
    @GetMapping("get/{id}")
    public R get(@PathVariable String id) {
        ForumComment ForumComment = forumCategoryService.getById(id);
        return R.ok().data("item", ForumComment);
    }

    //用户查看论坛评论列表
    @GetMapping("pageForumComment/{page}/{limit}")
    public R pageForumComment(@PathVariable long page, @PathVariable long limit, ForumComment forumCategory) {
        Page<ForumComment> pageForumComment = new Page<>(page, limit);
        // 构造条件
        QueryWrapper<ForumComment> wrapper = new QueryWrapper<>();
        //排序
        wrapper.orderBy(true, false, "gmt_create");
        // 判断条件值是否为空，如果不为空拼接条件
        if (!StringUtils.isEmpty(forumCategory.getPostId())) {
            // 构造条件
            wrapper.lambda().eq(ForumComment::getPostId, forumCategory.getPostId());
        }
        if (!StringUtils.isEmpty(forumCategory.getUserId())) {
            wrapper.lambda().eq(ForumComment::getUserId, forumCategory.getUserId());
        }
        if (!StringUtils.isEmpty(forumCategory.getParentId())) {
            wrapper.lambda().eq(ForumComment::getParentId, forumCategory.getParentId());
        }
        forumCategoryService.page(pageForumComment, null);
        return R.ok().data("items", pageForumComment.getRecords()).data("total", pageForumComment.getTotal());
    }

}

