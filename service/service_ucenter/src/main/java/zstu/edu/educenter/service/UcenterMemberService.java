package zstu.edu.educenter.service;

import zstu.edu.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import zstu.edu.educenter.entity.vo.RegisterVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author mier
 * @since 2023-04-24
 */
public interface UcenterMemberService extends IService<UcenterMember> {
    String login(UcenterMember member);

    void register(RegisterVo registerVo);

    UcenterMember getOpenIdMember(String openid);

    Integer countRegisterDay(String day);
}
