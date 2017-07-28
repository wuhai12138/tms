package com.jygj.summ.utils;

public class SwitchUtil {

    public static String missionStatus(String mission_status) {

        if (mission_status.equals("1")) {
            return "未开工";
        } else if (mission_status.equals("2")) {
            return "已完工";
        } else if (mission_status.equals("3")) {
            return "已暂停";
        } else if (mission_status.equals("4")) {
            return "已取消";
        } else {
            return mission_status + "";
        }

    }

    public static String sign(String sign) {
        if (sign.equals("1")) {
            return "未签到";
        } else if (sign.equals("2")) {
            return "已签到";
        } else {
            return sign + "";
        }


    }

    public  static String visitStatus(String visit_status){
        //回访状态（0全部1未拜访2已拜访3已评价）
        if (visit_status.equals("1")) {
            return "未拜访";
        } else if (visit_status.equals("2")) {
            return "已拜访";
        } else if (visit_status.equals("3")) {
            return "已评价";
        }else {
            return "";
        }
    }

    public static  String visitType(String visit_type){
        //回访类型（0全部1整改2试工3两周4一月5稳定6换季7考核8二月）
        if (visit_type.equals("1")) {
            return "整改";
        } else if (visit_type.equals("2")) {
            return "试工";
        } else if (visit_type.equals("3")) {
            return "两周";
        }else if (visit_type.equals("4")) {
            return "一月";
        }else if (visit_type.equals("5")) {
            return "稳定";
        }else if (visit_type.equals("6")) {
            return "换季";
        }else if (visit_type.equals("7")) {
            return "考核";
        }else if (visit_type.equals("8")) {
            return "二月";
        }else {
            return "";
        }
    }

    public static  String orderType(String order_type){
        //订单类型 0全部1合同2包月3一次性4免费
        if (order_type.equals("1")) {
            return "合同订单";
        } else if (order_type.equals("2")) {
            return "包月订单";
        } else if (order_type.equals("3")) {
            return "一次性订单";
        }else if (order_type.equals("4")) {
            return "免费订单";
        }else {
            return "";
        }
    }

    public static  String orderStatus(String order_type){
        //订单状态 1预约中/2未配单/3已配单(已删除此状态)/4试工中/5已开工/6已完工
        if (order_type.equals("1")) {
            return "预约中";
        } else if (order_type.equals("2")) {
            return "未配单";
        } else if (order_type.equals("3")) {
            return "已配单";
        }else if (order_type.equals("4")) {
            return "试工中";
        }else if (order_type.equals("5")) {
            return "已开工";
        }else if (order_type.equals("6")) {
            return "已完工";
        }else {
            return "";
        }
    }
}
