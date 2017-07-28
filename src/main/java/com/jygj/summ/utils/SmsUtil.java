package com.jygj.summ.utils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * Created by Mc on 2016/11/30.
 */
public class SmsUtil {

    private static String serverUrl = "http://gw.api.taobao.com/router/rest";
    private static String appKey = "23552143";
    private static String appSecret = "eb64929165bad6afab0ef343aa95f056";

    public static String SMS_24 = "SMS_31495093";//24小时通知
    public static String SMS_7 = "SMS_31760007";//7天余额不足
//    public static String SMS_24 = "SMS_31495093";//24小时通知
//    public static String SMS_24 = "SMS_31495093";//24小时通知
//    public static String SMS_24 = "SMS_31495093";//24小时通知



    public static void sendSms(String paramJson,String phone,String sms_id) {
        TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("");//公共回传参数，在“消息返回”中会传回该参数
        req.setSmsType("normal");//固定值
        req.setSmsFreeSignName("家有管家");//签名名称
        req.setSmsParamString(paramJson);//参数json
        req.setRecNum(phone);//接收人手机号
        req.setSmsTemplateCode(sms_id);//模版id
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
            System.out.println("短信发送失败: " + e.getMessage());
        }
    }
}
