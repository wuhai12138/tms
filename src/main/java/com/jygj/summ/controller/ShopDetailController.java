package com.jygj.summ.controller;

import com.jygj.summ.mapper.ShopMapper;
import com.jygj.summ.model.response.ShopDetailResponse;
import com.jygj.summ.view.response.ModelRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jygj_7500 on 2017/7/25.
 */
@Controller
public class ShopDetailController {

    @Autowired
    private ShopMapper shopMapper;

    @ResponseBody
    @RequestMapping("/shop")
    public Object getShopDetail(Integer train_id){
        List<ShopDetailResponse> list = shopMapper.getShopDetail(train_id);
        String url = "https://spay3.swiftpass.cn/spay/payMoneyNew?openID=oBqbzs7CL5iGfE0cLEGHFUb0GWqU&redirect=true&mchId=133500000263&client=platform&userId=";
        for(int i = 0; i < list.size(); i++){
            list.get(i).setPaycode(url + list.get(i).getPaycode());
        }
        Map map = new HashMap();
        map.put("train_id",train_id);
        map.put("list",list);
        return new ModelRes(ModelRes.Status.SUCCESS, "门店详情!", map);
    }

}
