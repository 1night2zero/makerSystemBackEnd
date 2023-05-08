package zstu.edu.eduservice.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import zstu.edu.commonutils.R;
import zstu.edu.eduservice.entity.EduComment;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author mier
 * @since 2023-04-27
 */
public interface EduCommentService extends IService<EduComment> {


    Map<String, Object> getCommentPage(Page<EduComment> page, QueryWrapper<EduComment> wrapper);

    R saveComment(EduComment comment, HttpServletRequest request);
}
