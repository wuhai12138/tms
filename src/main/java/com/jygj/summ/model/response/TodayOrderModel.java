package com.jygj.summ.model.response;

import com.sun.scenario.effect.impl.prism.PrImage;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Date;

/**
 * Created by jygj_7500 on 2017/7/20.
 */
public class TodayOrderModel {
    private Integer ReVisitId;
    private Date ReVisitDate;
    private String ReVisitStatus;
    private String VisitType;
    private String house_address;
    private Integer shop_id;
    private String shop_name;
    private Integer mission_id;
    private String nanny_name;
    private Integer days;
    private String mission_time;

    public String getReVisitStatus() {
        return ReVisitStatus;
    }

    public void setReVisitStatus(String reVisitStatus) {
        ReVisitStatus = reVisitStatus;
    }

    public String getVisitType() {
        return VisitType;
    }

    public void setVisitType(String visitType) {
        VisitType = visitType;
    }

    public String getMission_time() {
        return mission_time;
    }

    public void setMission_time(String mission_time) {
        this.mission_time = mission_time;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getReVisitId() {
        return ReVisitId;
    }

    public void setReVisitId(Integer reVisitId) {
        ReVisitId = reVisitId;
    }

    public Date getReVisitDate() {
        return ReVisitDate;
    }

    public void setReVisitDate(Date reVisitDate) {
        ReVisitDate = reVisitDate;
    }

    public String getHouse_address() {
        return house_address;
    }

    public void setHouse_address(String house_address) {
        this.house_address = house_address;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public Integer getMission_id() {
        return mission_id;
    }

    public void setMission_id(Integer mission_id) {
        this.mission_id = mission_id;
    }

    public String getNanny_name() {
        return nanny_name;
    }

    public void setNanny_name(String nanny_name) {
        this.nanny_name = nanny_name;
    }
}
