package zstu.edu.forumservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zstu.edu.commonutils.R;
import zstu.edu.forumservice.entity.ForumComment;
import zstu.edu.forumservice.entity.ForumPost;
import zstu.edu.forumservice.service.ForumCommentService;
import zstu.edu.forumservice.service.ForumPostService;

/**
 * <p>
 * 论坛帖子表 前端控制器
 * </p>
 *
 * @author mier
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/forumservice/forum-post")
public class ForumPostController {

    @Autowired
    private ForumPostService forumPostService;

    @Autowired
    private ForumCommentService forumCommentService;

    //用户发帖
    @PostMapping("addForumPost")
    public R addForumPost(@RequestBody ForumPost forumPost) {
        forumPostService.save(forumPost);
        return R.ok();
    }

    //用户删除帖子
    @ApiOperation(value = "删除ForumPost")
    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id) {
        forumPostService.removeById(id);
        return R.ok();
    }

    //用户修改帖子
    @ApiOperation(value = "修改ForumPost")
    @PutMapping("update")
    public R updateById(@RequestBody ForumPost forumPost) {
        forumPostService.updateById(forumPost);
        return R.ok();
    }

    //用户查看帖子
    //用户查看帖子详情
    @ApiOperation(value = "获取ForumPost")
    @GetMapping("get/{id}")
    public R get(@PathVariable String id) {
        ForumPost forumPost = forumPostService.getById(id);
        return R.ok().data("item", forumPost);
    }

    //用户查看帖子列表
    @GetMapping("pageForumPost/{page}/{limit}")
    public R pageForumPost(@PathVariable long page, @PathVariable long limit, ForumPost forumPost) {
        Page<ForumPost> pageForumPost = new Page<>(page, limit);
        // 构造条件
        QueryWrapper<ForumPost> wrapper = new QueryWrapper<>();
        //排序
        wrapper.orderBy(true, false, "gmt_create");

        // 判断条件值是否为空，如果不为空拼接条件
        if (!StringUtils.isEmpty(forumPost.getUserId())) {
            // 构造条件
            wrapper.lambda().eq(ForumPost::getUserId, forumPost.getUserId());
        }
        if (!StringUtils.isEmpty(forumPost.getCategoryId())) {
            wrapper.lambda().eq(ForumPost::getCategoryId, forumPost.getCategoryId());
        }
        if (!StringUtils.isEmpty(forumPost.getTitle())) {
            wrapper.lambda().like(ForumPost::getTitle, forumPost.getTitle());
        }
        forumPostService.page(pageForumPost, null);
        return R.ok().data("items", pageForumPost.getRecords()).data("total", pageForumPost.getTotal());
    }

    //用户查看帖子评论列表
    @GetMapping("pageForumComment/{page}/{limit}")
    public R pageForumComment(@PathVariable long page, @PathVariable long limit, ForumComment forumComment) {
        Page<ForumComment> pageForumPost = new Page<>(page, limit);
        // 构造条件
        QueryWrapper<ForumComment> wrapper = new QueryWrapper<>();
        //排序
        wrapper.orderBy(true, false, "gmt_create");

        // 判断条件值是否为空，如果不为空拼接条件
        if (!StringUtils.isEmpty(forumComment.getPostId())) {
            // 构造条件
            wrapper.lambda().eq(ForumComment::getPostId, forumComment.getPostId());
        }
        if (!StringUtils.isEmpty(forumComment.getUserId())) {
            wrapper.lambda().eq(ForumComment::getUserId, forumComment.getUserId());
        }
        if (!StringUtils.isEmpty(forumComment.getParentId())) {
            wrapper.lambda().like(ForumComment::getParentId, forumComment.getParentId());
        }
        forumCommentService.page(pageForumPost, wrapper);
        return R.ok().data("items", pageForumPost.getRecords()).data("total", pageForumPost.getTotal());
    }


}




