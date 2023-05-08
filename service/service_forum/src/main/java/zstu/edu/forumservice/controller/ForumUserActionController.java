package zstu.edu.forumservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import zstu.edu.commonutils.R;
import zstu.edu.forumservice.entity.ForumUserAction;
import zstu.edu.forumservice.service.ForumUserActionService;

/**
 * <p>
 * 用户操作表（包括收藏和点赞） 前端控制器
 * </p>
 *
 * @author mier
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/forumservice/forum-user-action")
public class ForumUserActionController {

    @Autowired
    private ForumUserActionService forumCategoryService;

    //用户操作表
    @PostMapping("addForumUserAction")
    public R addForumUserAction(@RequestBody ForumUserAction forumUserAction) {
        forumCategoryService.save(forumUserAction);
        return R.ok();
    }

    //用户删除用户操作表（包括收藏和点赞）
    @ApiOperation(value = "删除ForumUserAction")
    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id) {
        forumCategoryService.removeById(id);
        return R.ok();
    }

    //用户修改用户操作表（包括收藏和点赞）
    @ApiOperation(value = "修改ForumUserAction")
    @PutMapping("update")
    public R updateById(@RequestBody ForumUserAction ForumUserAction) {
        forumCategoryService.updateById(ForumUserAction);
        return R.ok();
    }

    //用户查看用户操作表（包括收藏和点赞）
    //用户查看用户操作表（包括收藏和点赞）详情
    @ApiOperation(value = "获取ForumUserAction")
    @GetMapping("get/{id}")
    public R get(@PathVariable String id) {
        ForumUserAction ForumUserAction = forumCategoryService.getById(id);
        return R.ok().data("item", ForumUserAction);
    }

    //用户查看用户操作表（包括收藏和点赞）列表
    @GetMapping("pageForumUserAction/{page}/{limit}")
    public R pageForumUserAction(@PathVariable long page, @PathVariable long limit, ForumUserAction forumCategory) {
        Page<ForumUserAction> pageForumUserAction = new Page<>(page, limit);
        // 构造条件
        QueryWrapper<ForumUserAction> wrapper = new QueryWrapper<>();
        //排序
        wrapper.orderBy(true, false, "gmt_create");
        // 判断条件值是否为空，如果不为空拼接条件
        if (!StringUtils.isEmpty(forumCategory.getPostId())) {
            // 构造条件
            wrapper.lambda().eq(ForumUserAction::getPostId, forumCategory.getPostId());
        }
        if (!StringUtils.isEmpty(forumCategory.getUserId())) {
            wrapper.lambda().eq(ForumUserAction::getUserId, forumCategory.getUserId());
        }
        if (!StringUtils.isEmpty(forumCategory.getActionType())) {
            wrapper.lambda().eq(ForumUserAction::getActionType, forumCategory.getActionType());
        }
        forumCategoryService.page(pageForumUserAction, null);
        return R.ok().data("items", pageForumUserAction.getRecords()).data("total", pageForumUserAction.getTotal());
    }

}

