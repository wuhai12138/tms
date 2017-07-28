package com.jygj.summ.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jygj.summ.mapper.OrderBigMapper;
import com.jygj.summ.model.Test;
import com.jygj.summ.service.ITestService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jygj_7500 on 2017/7/19.
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService iTestService;

    @ResponseBody
    @RequestMapping("/get")
    public String test(){
        Test test = new Test();
        test.setName("cc");
        EntityWrapper<Test> entityWrapper = new EntityWrapper<Test>();
        iTestService.selectPage(new Page<Test>(2,5), entityWrapper);
        entityWrapper.setEntity(test);
        iTestService.selectPage(new Page<Test>(1, 5), entityWrapper);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/post")
    public String post(String phone, String password){
        System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
        return phone+password;
    }

}


