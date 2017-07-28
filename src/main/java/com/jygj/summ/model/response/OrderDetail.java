package com.jygj.summ.model.response;

import com.jygj.summ.model.OrderBig;

import java.util.Date;
import java.util.List;

/**
 * Created by jygj_7500 on 2017/7/21.
 */
public class OrderDetail {
    private Integer orderId;
    private Date orderStartDate;
    private Date orderEndDate;
    private String orderType;
    private String orderStatus;
    private String backup;
    private String needJson;
    private Integer serviceCycle;
    private String customer_name;
    private String customer_phone;
    private String house_address;
    private List need_json_list;
    private String shop_name;
    private String train_name;

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

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

    public String getNeedJson() {
        return needJson;
    }

    public void setNeedJson(String needJson) {
        this.needJson = needJson;
    }

    public Integer getServiceCycle() {
        return serviceCycle;
    }

    public void setServiceCycle(Integer serviceCycle) {
        this.serviceCycle = serviceCycle;
    }

    public List getNeed_json_list() {
        return need_json_list;
    }

    public void setNeed_json_list(List need_json_list) {
        this.need_json_list = need_json_list;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getHouse_address() {
        return house_address;
    }

    public void setHouse_address(String house_address) {
        this.house_address = house_address;
    }
}
