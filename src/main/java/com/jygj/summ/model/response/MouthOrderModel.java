package com.jygj.summ.model.response;

import java.util.Date;

/**
 * Created by jygj_7500 on 2017/7/20.
 */
public class MouthOrderModel {
    /** 订单id */
    private Integer orderId;

    /** 订单开始时间 */
    private Date orderStartDate;

    /** 订单结束时间 */
    private Date orderEndDate;

    /** 0全部1合同2包月3一次性4免费 */
    private String orderType;

    /** 1预约中/2未配单/3已配单(已删除此状态)/4试工中/5已开工/6已完工 */
    private String orderStatus;

    /** 备注 */
    private String backup;

    private String house_address;

    private Integer orders;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(Date orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    public Date getOrderEndDate() {
        return orderEndDate;
    }

    public void setOrderEndDate(Date orderEndDate) {
        this.orderEndDate = orderEndDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public String getHouse_address() {
        return house_address;
    }

    public void setHouse_address(String house_address) {
        this.house_address = house_address;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}
