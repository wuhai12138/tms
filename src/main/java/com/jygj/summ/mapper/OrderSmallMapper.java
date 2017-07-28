package com.jygj.summ.mapper;

import com.jygj.summ.model.OrderSmall;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.jygj.summ.model.response.TodatMission;

import java.util.List;
import java.util.Map;


/**
 *
 * OrderSmall 表数据库控制层接口
 *
 */
public interface OrderSmallMapper extends AutoMapper<OrderSmall> {

    List<TodatMission> getTodayMission(Map map);

}