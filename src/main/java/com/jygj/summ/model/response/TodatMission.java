package com.jygj.summ.model.response;

import java.util.Date;

/**
 * Created by jygj_7500 on 2017/7/25.
 */
public class TodatMission {

    private Integer missionId;
    private Date missionDate;
    private String missionTime;
    private Double missionHour;
    private String missionStatus;
    private String orderType;
    private String missionType;
    private String customerName;
    private String customerPhone;
    private String houseAddress;

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer missionId) {
        this.missionId = missionId;
    }

    public Date getMissionDate() {
        return missionDate;
    }

    public void setMissionDate(Date missionDate) {
        this.missionDate = missionDate;
    }

    public String getMissionTime() {
        return missionTime;
    }

    public void setMissionTime(String missionTime) {
        this.missionTime = missionTime;
    }

    public Double getMissionHour() {
        return missionHour;
    }

    public void setMissionHour(Double missionHour) {
        this.missionHour = missionHour;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }
}
