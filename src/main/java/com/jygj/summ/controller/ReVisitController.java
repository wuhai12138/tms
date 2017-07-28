package com.jygj.summ.controller;

import com.jygj.summ.mapper.OrderSmallMapper;
import com.jygj.summ.mapper.ReVisitOrderMapper;
import com.jygj.summ.model.ReVisitOrder;
import com.jygj.summ.model.response.TodatMission;
import com.jygj.summ.model.response.TodayOrderModel;
import com.jygj.summ.service.IReVisitOrderService;
import com.jygj.summ.utils.DateUtil;
import com.jygj.summ.utils.SwitchUtil;
import com.jygj.summ.view.response.ModelRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jygj_7500 on 2017/7/20.
 */
@Controller
public class ReVisitController {
    @Autowired
    private OrderSmallMapper orderSmallMapper;

    @Autowired
    private ReVisitOrderMapper reVisitOrderMapper;

    @ResponseBody
    @RequestMapping("/today")
    public Object getTodayOrder(int train_id, String date, int nanny_id) throws ParseException {
        Map mapVisit = new HashMap();
        Date date1 = DateUtil.stringForDate(date);
        mapVisit.put("train_id", train_id);
        mapVisit.put("date", DateUtil.parseDateToString(date1,DateUtil.PATTERN_yyyy_MM_dd_HHmmss));
        mapVisit.put("nanny_id",nanny_id);
        List<TodayOrderModel> todayOrderModel = reVisitOrderMapper.getTodayOrder(mapVisit);
        for(int i = 0; i < todayOrderModel.size(); i++){
            int days = DateUtil.getDateCha(todayOrderModel.get(i).getReVisitDate(),date1);
            todayOrderModel.get(i).setDays(days);
            String reVisitStatus = SwitchUtil.visitStatus(todayOrderModel.get(i).getReVisitStatus());
            todayOrderModel.get(i).setReVisitStatus(reVisitStatus);
            String visitType = SwitchUtil.visitType(todayOrderModel.get(i).getVisitType());
            todayOrderModel.get(i).setVisitType(visitType);
        }

        mapVisit.put("date", DateUtil.parseDateToString(date1,DateUtil.PATTERN_yyyy_MM_dd));
        List<TodatMission> todayMissList = orderSmallMapper.getTodayMission(mapVisit);
        for(int i = 0; i < todayMissList.size(); i ++){
            todayMissList.get(i).setOrderType(SwitchUtil.orderType(todayMissList.get(i).getOrderType()));
            todayMissList.get(i).setMissionStatus(SwitchUtil.missionStatus(todayMissList.get(i).getMissionStatus()));
        }

        Map mapOrder = new HashMap();
        mapOrder.put("todayVisitList", todayOrderModel);
        mapOrder.put("todayMissionList",todayMissList);
        return new ModelRes(ModelRes.Status.SUCCESS, "今日回访订单!", mapOrder);
    }

    @ResponseBody
    @RequestMapping("/visit")
    public Object confirmVisit(Integer reVisitId, Integer nanny_id, Integer assess, String assessContent, Integer mission_id) {
        //确认拜访，更新评价
        Map map = new HashMap();
        map.put("ReVisitId",reVisitId);
        map.put("nanny_id",nanny_id);
        map.put("Assess",assess);
        map.put("AssessContent",assessContent);
        map.put("mission_id", mission_id);
        if(assess != null|| assessContent != null){
            map.put("ReVisitStatus",3);
        }else {
            map.put("ReVisitStatus",2);
        }
//        iReVisitOrderService.update(reVisitOrderId, reVisitOrder);
        reVisitOrderMapper.updateById(map);
        return new ModelRes(ModelRes.Status.SUCCESS, "更新订单信息成功!");
    }

}
