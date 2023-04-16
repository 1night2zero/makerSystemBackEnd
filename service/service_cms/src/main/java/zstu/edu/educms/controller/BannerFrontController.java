package zstu.edu.educms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zstu.edu.commonutils.R;
import zstu.edu.educms.entity.CrmBanner;
import zstu.edu.educms.service.CrmBannerService;

import java.util.List;

/**
 * <p>
 * 前台bannber显示
 * </p>
 *
 * @author 1night2zero
 * @mier 2023-03-07
 */
@RestController
@RequestMapping("/educms/bannerfront")
@CrossOrigin
public class BannerFrontController {

    @Autowired
    private CrmBannerService bannerService;

    //查询所有banner
    @GetMapping("getAllBanner")
    public R getAllBanner() {
        List<CrmBanner> list = bannerService.getBannerList();
        return R.ok().data("list",list);
    }
}

