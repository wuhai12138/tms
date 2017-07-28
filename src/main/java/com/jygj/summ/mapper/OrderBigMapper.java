package com.jygj.summ.mapper;

import com.jygj.summ.model.OrderBig;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.jygj.summ.model.response.MouthOrderModel;
import com.jygj.summ.model.response.OrderDetail;

import java.util.List;
import java.util.Map;

/**
 *
 * OrderBig 表数据库控制层接口
 *
 */
public interface OrderBigMapper extends AutoMapper<OrderBig> {

    List<MouthOrderModel> getOrder(Map map);

    Integer getCount(Map map);

    OrderDetail getOrderDetail(String order_id);
}