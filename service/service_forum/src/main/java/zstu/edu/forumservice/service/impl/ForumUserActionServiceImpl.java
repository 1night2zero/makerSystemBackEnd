package zstu.edu.forumservice.service.impl;

import zstu.edu.forumservice.entity.ForumUserAction;
import zstu.edu.forumservice.mapper.ForumUserActionMapper;
import zstu.edu.forumservice.service.ForumUserActionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户操作表（包括收藏和点赞） 服务实现类
 * </p>
 *
 * @author mier
 * @since 2023-04-24
 */
@Service
public class ForumUserActionServiceImpl extends ServiceImpl<ForumUserActionMapper, ForumUserAction> implements ForumUserActionService {

}
