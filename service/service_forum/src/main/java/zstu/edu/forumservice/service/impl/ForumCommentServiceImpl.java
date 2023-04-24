package zstu.edu.forumservice.service.impl;

import zstu.edu.forumservice.entity.ForumComment;
import zstu.edu.forumservice.mapper.ForumCommentMapper;
import zstu.edu.forumservice.service.ForumCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 论坛评论表 服务实现类
 * </p>
 *
 * @author mier
 * @since 2023-04-24
 */
@Service
public class ForumCommentServiceImpl extends ServiceImpl<ForumCommentMapper, ForumComment> implements ForumCommentService {

}
