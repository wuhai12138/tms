package com.jygj.summ.mapper;

import com.jygj.summ.model.ReVisitOrder;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.jygj.summ.model.response.TodayOrderModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 *
 * ReVisitOrder 表数据库控制层接口
 *
 */
public interface ReVisitOrderMapper extends AutoMapper<ReVisitOrder> {

    List<TodayOrderModel> getTodayOrder(Map map);

    boolean updateById( Map map);

}