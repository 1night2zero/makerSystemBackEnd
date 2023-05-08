package zstu.edu.eduservice.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import zstu.edu.commonutils.JwtUtils;
import zstu.edu.commonutils.R;
import zstu.edu.eduservice.client.UcenterClient;
import zstu.edu.eduservice.entity.EduComment;
import zstu.edu.eduservice.mapper.EduCommentMapper;
import zstu.edu.eduservice.service.EduCommentService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author mier
 * @since 2023-04-27
 */
@Service
public class EduCommentServiceImpl extends ServiceImpl<EduCommentMapper, EduComment> implements EduCommentService {

    @Autowired
    private UcenterClient ucenterClient;


    //分页查询所有的评论
    @Override
    public Map<String, Object> getCommentPage(Page<EduComment> page, QueryWrapper<EduComment> wrapper) {
        baseMapper.selectPage(page, wrapper);
        List<EduComment> commentList = page.getRecords();

        Map<String, Object> map = new HashMap<>();
        map.put("items", commentList);
        map.put("current", page.getCurrent());
        map.put("pages", page.getPages());
        map.put("size", page.getSize());
        map.put("total", page.getTotal());
        map.put("hasNext", page.hasNext());
        map.put("hasPrevious", page.hasPrevious());

        return map;
    }


    //将评论存入数据库中
    @Override
    public R saveComment(EduComment comment, HttpServletRequest request) {
//        System.out.println("request token:"+request.getHeader("token"));
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        System.out.println("memberId" + memberId);
        if (StringUtils.isEmpty(memberId)) {
            return R.error().message("请先登录");
//            memberId = "1";
        }
        comment.setMemberId(memberId);
        String avatar = ucenterClient.getMemberInfoById(memberId).getAvatar();
        String nickName = ucenterClient.getMemberInfoById(memberId).getNickname();
        comment.setAvatar(avatar);
        comment.setNickname(nickName);

        baseMapper.insert(comment);
        return R.ok();
    }
}
