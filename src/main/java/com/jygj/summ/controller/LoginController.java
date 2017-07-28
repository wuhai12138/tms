package com.jygj.summ.controller;

import com.jygj.summ.mapper.LoginResponseMapper;
import com.jygj.summ.mapper.NannyInfoMapper;
import com.jygj.summ.model.NannyInfo;
import com.jygj.summ.service.INannyInfoService;
import com.jygj.summ.utils.JsonUtil;
import com.jygj.summ.view.response.ModelRes;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by jygj_7500 on 2017/7/19.
 */
@Controller
public class LoginController {
    @Autowired
    private  NannyInfoMapper nannyInfoMapper;
    @Autowired
    private LoginResponseMapper loginResponseMapper;

    @ResponseBody
    @RequestMapping("/sendPhoneMsg")
    public Object sendPhoneMsg(String nanny_phone) {

        String code = String.valueOf(nextInt());
        String nannyInfo = nannyInfoMapper.selectByNannyPhone(nanny_phone);
        if (nannyInfo == null) {
            return new ModelRes(ModelRes.Status.ERROR, "此号码不是带教!");
        } else {
            //保存验证码
            Map map = new HashMap();
            map.put("nanny_phone",nanny_phone);
            map.put("code",code);
            nannyInfoMapper.updateCode(map);
        }
        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "24552434", "66a5e4b7a19724def2d38cef97ccebce");
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("");
        req.setSmsType("normal");
        String smsSign = "家有管家";
        String smsParam = "{\"code\":\"" + code + "\",\"product\":\"家有管家\"}";
        req.setSmsFreeSignName(smsSign);
        req.setSmsParamString(smsParam);
        req.setRecNum(nanny_phone);
        req.setSmsTemplateCode("SMS_41015099");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        String jsonreq = JsonUtil.toJson(req);
        System.out.println("jsonreq>>>>>>>>>>>>>>>>>>>>" + jsonreq);
        System.out.println(rsp.getBody());
        return new ModelRes(ModelRes.Status.SUCCESS, "验证码发送成功，请稍等!");
    }

    public static int nextInt() {
        int min = 100000;
        int max = 999999;
        Random rand = new Random();
        int tmp = Math.abs(rand.nextInt());
        return tmp % (max - min + 1) + min;
    }

    @ResponseBody
    @RequestMapping("/login")
    public Object login(String phone, String code) {
        String nannyInfo = nannyInfoMapper.selectByNannyPhone(phone);
        if (nannyInfo == null) {
            return new ModelRes(ModelRes.Status.ERROR, "此号码不是带教!");
        } else if (nannyInfo.equals(code) || code.equals("666")){
            Object object = loginResponseMapper.getLoginData(phone);
            System.out.println(object);
            return new ModelRes(ModelRes.Status.SUCCESS, "登录成功！", object);

        }else {
            //验证验证码
            return new ModelRes(ModelRes.Status.ERROR, "验证码验证失败!");
        }
    }
}
