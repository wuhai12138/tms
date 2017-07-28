package com.jygj.summ.mapper;

import com.jygj.summ.model.NannyInfo;
import com.baomidou.mybatisplus.mapper.AutoMapper;

import java.util.Map;

/**
 *
 * NannyInfo 表数据库控制层接口
 *
 */
public interface NannyInfoMapper extends AutoMapper<NannyInfo> {

    String selectByNannyPhone(String phone);

    boolean updateCode(Map map);

}