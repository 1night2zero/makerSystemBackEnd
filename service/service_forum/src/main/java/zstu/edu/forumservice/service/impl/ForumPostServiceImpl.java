package zstu.edu.forumservice.service.impl;

import zstu.edu.forumservice.entity.ForumPost;
import zstu.edu.forumservice.mapper.ForumPostMapper;
import zstu.edu.forumservice.service.ForumPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论坛帖子表 服务实现类
 * </p>
 *
 * @author mier
 * @since 2023-04-24
 */
@Service
public class ForumPostServiceImpl extends ServiceImpl<ForumPostMapper, ForumPost> implements ForumPostService {

}
