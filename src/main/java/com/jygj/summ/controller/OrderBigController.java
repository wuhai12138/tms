package com.jygj.summ.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.jygj.summ.mapper.OrderBigMapper;
import com.jygj.summ.model.response.MouthOrderModel;
import com.jygj.summ.model.response.MouthOrderResModel;
import com.jygj.summ.model.response.OrderDetail;
import com.jygj.summ.service.IOrderBigService;
import com.jygj.summ.utils.DateUtil;
import com.jygj.summ.utils.SwitchUtil;
import com.jygj.summ.view.response.ModelRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by jygj_7500 on 2017/7/20.
 */
@Controller
public class OrderBigController {

    @Autowired
    private OrderBigMapper orderBigMapper;

    @Autowired
    private IOrderBigService iOrderBigService;

    @ResponseBody
    @RequestMapping("/order")
    public Object getOrder(Integer train_id, String date, Integer page) throws ParseException {
        Map map = new HashMap();
        Date date1 = DateUtil.stringForDate(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);

        String start_time = DateUtil.getMinMonthDate(date1) + " 00:00:00";
        String end_time = DateUtil.getMaxMonthDate(date1) + " 23:59:59";
        map.put("start_time",start_time);
        map.put("end_time", end_time);
        map.put("train_id", train_id);
        map.put("page", page-1);
        List<MouthOrderModel> mouthOrderModels = orderBigMapper.getOrder(map);
        for(int i = 0; i < mouthOrderModels.size(); i++){
            mouthOrderModels.get(i).setOrderType(SwitchUtil.orderType(mouthOrderModels.get(i).getOrderType()));
            mouthOrderModels.get(i).setOrderStatus(SwitchUtil.orderStatus(mouthOrderModels.get(i).getOrderStatus()));
        }

        Integer orders =  orderBigMapper.getCount(map);
        MouthOrderResModel mouthOrderResModel = new MouthOrderResModel();
        mouthOrderResModel.setList(mouthOrderModels);
        mouthOrderResModel.setOrders(orders);
        return new ModelRes(ModelRes.Status.SUCCESS, "本月全部订单!", mouthOrderResModel);
    }

    @ResponseBody
    @RequestMapping("/orderDetail")
    public Object getOrderDetail(String order_id){
        OrderDetail orderDetail = orderBigMapper.getOrderDetail(order_id);
        orderDetail.setOrderType(SwitchUtil.orderType(orderDetail.getOrderType()));
        orderDetail.setOrderStatus(SwitchUtil.orderStatus(orderDetail.getOrderStatus()));
        List list = JSON.parseArray(orderDetail.getNeedJson());
        orderDetail.setNeed_json_list(list);
        return new ModelRes(ModelRes.Status.SUCCESS, "订单详情!", orderDetail);
    }
}
