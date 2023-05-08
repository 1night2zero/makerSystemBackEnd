package zstu.edu.forumservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zstu.edu.commonutils.R;
import zstu.edu.forumservice.entity.ForumCategory;
import zstu.edu.forumservice.service.ForumCategoryService;


/**
 * <p>
 * 论坛分类表 前端控制器
 * </p>
 *
 * @author mier
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/forumservice/forum-category")
@Api(tags = "论坛分类表 前端控制器")
public class ForumCategoryController {

    @Autowired
    private ForumCategoryService forumCategoryService;

    //论坛分类表
    @ApiOperation(value = "添加论坛分类表")
    @PostMapping("addForumCategory")
    public R addForumCategory(@RequestBody ForumCategory forumCategory) {
        forumCategoryService.save(forumCategory);
        return R.ok();
    }

    //用户删除论坛分类
    @ApiOperation(value = "删除ForumCategory")
    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id) {
        forumCategoryService.removeById(id);
        return R.ok();
    }

    //用户修改论坛分类
    @ApiOperation(value = "修改ForumCategory")
    @PutMapping("update")
    public R updateById(@RequestBody ForumCategory forumCategory) {
        forumCategoryService.updateById(forumCategory);
        return R.ok();
    }

    //用户查看论坛分类
    //用户查看论坛分类详情
    @ApiOperation(value = "获取ForumCategory")
    @GetMapping("get/{id}")
    public R get(@PathVariable String id) {
        ForumCategory ForumCategory = forumCategoryService.getById(id);
        return R.ok().data("item", ForumCategory);
    }

    //用户查看论坛分类列表
    @GetMapping("pageForumCategory/{page}/{limit}")
    public R pageForumCategory(@PathVariable long page, @PathVariable long limit, ForumCategory forumCategory) {
        Page<ForumCategory> pageForumCategory = new Page<>(page, limit);
        // 构造条件
        QueryWrapper<ForumCategory> wrapper = new QueryWrapper<>();
        //排序
        wrapper.orderBy(true, false, "gmt_create");
        // 判断条件值是否为空，如果不为空拼接条件
        if (!StringUtils.isEmpty(forumCategory.getName())) {
            // 构造条件
            wrapper.lambda().like(ForumCategory::getName, forumCategory.getName());
        }
        forumCategoryService.page(pageForumCategory, null);
        return R.ok().data("items", pageForumCategory.getRecords()).data("total", pageForumCategory.getTotal());
    }

}
