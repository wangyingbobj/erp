package com.erp.main.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.erp.common.dto.Pagination;
import com.erp.common.entity.ResultPoJo;
import com.erp.main.entity.BzjEcAd;
import com.erp.main.mapper.BzjEcAdMapper;
import com.erp.main.service.IBzjEcAdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 广告表 服务实现类
 * </p>
 *
 * @author 帅帅
 * @since 2021-01-18
 */
@Service
public class BzjEcAdServiceImpl extends ServiceImpl<BzjEcAdMapper, BzjEcAd> implements IBzjEcAdService {

    public Pagination<BzjEcAd> select1 (Integer pagenum,Integer pagesize){
        LambdaQueryWrapper<BzjEcAd> wrapper = new QueryWrapper<BzjEcAd>().lambda()
                .select(BzjEcAd::getId)
                .eq(BzjEcAd::getId, 1);

        Pagination<BzjEcAd> pagination = new Pagination<>();
        pagination.setPageNum(pagenum);
        pagination.setPageSize(pagesize);
        IPage<BzjEcAd> page = getBaseMapper().selectPage(pagination.page(), wrapper);
        pagination.setData(page.getRecords());
        pagination.setTotal(page.getTotal());

        return pagination;
    }
}
