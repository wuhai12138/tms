package com.jygj.summ.mapper;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.jygj.summ.model.response.LoginResponse;

/**
 * Created by jygj_7500 on 2017/7/19.
 */
public interface LoginResponseMapper extends AutoMapper<LoginResponse> {

    LoginResponse getLoginData(String phone);
}