package zstu.edu.educms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import zstu.edu.educms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;
import zstu.edu.educms.entity.vo.BannerVo;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author mier
 * @since 2023-04-16
 */
public interface CrmBannerService extends IService<CrmBanner> {

    void pageBanner(Page<CrmBanner> pageParam, BannerVo banner);

    List<CrmBanner> getBannerList();
}
