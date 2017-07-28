package com.jygj.summ.mapper;

import com.jygj.summ.model.Shop;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.jygj.summ.model.response.ShopDetailResponse;

import java.util.List;

/**
 *
 * Shop 表数据库控制层接口
 *
 */
public interface ShopMapper extends AutoMapper<Shop> {
    List<ShopDetailResponse> getShopDetail(Integer train_id);
}