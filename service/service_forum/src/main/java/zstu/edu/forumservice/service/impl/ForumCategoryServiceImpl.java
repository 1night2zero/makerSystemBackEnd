package zstu.edu.forumservice.service.impl;

import zstu.edu.forumservice.entity.ForumCategory;
import zstu.edu.forumservice.mapper.ForumCategoryMapper;
import zstu.edu.forumservice.service.ForumCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论坛分类表 服务实现类
 * </p>
 *
 * @author mier
 * @since 2023-04-24
 */
@Service
public class ForumCategoryServiceImpl extends ServiceImpl<ForumCategoryMapper, ForumCategory> implements ForumCategoryService {

}
