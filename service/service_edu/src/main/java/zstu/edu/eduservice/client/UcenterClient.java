package zstu.edu.eduservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import zstu.edu.commonutils.UcenterMemberVo;


@Component
@FeignClient(name = "service-ucenter",fallback = UcenterClientImpl.class)
public interface UcenterClient {

    @PostMapping("/ucenterservice/ucenter-member/getMemberInfoById/{memberId}")
    UcenterMemberVo getMemberInfoById(@PathVariable String memberId);

}