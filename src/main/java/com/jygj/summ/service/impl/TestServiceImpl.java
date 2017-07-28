package com.jygj.summ.service.impl;

import org.springframework.stereotype.Service;

import com.jygj.summ.mapper.TestMapper;
import com.jygj.summ.model.Test;
import com.jygj.summ.service.ITestService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Test 表数据服务层接口实现类
 *
 */
@Service
public class TestServiceImpl extends SuperServiceImpl<TestMapper, Test> implements ITestService {


}