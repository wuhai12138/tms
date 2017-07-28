package com.jygj.summ.model.response;

/**
 * Created by jygj_7500 on 2017/7/19.
 */
public class LoginResponse {
    private Integer nannyId;
    private String nannyName;
    private String nannyPhone;
    private String nannyAddress;
    private Integer trainId;
    private String trainPhone;
    private String trainName;

    public LoginResponse(Integer nannyId, String nannyName, String nannyPhone, String nannyAddress, Integer trainId, String trainPhone, String trainName) {
        this.nannyId = nannyId;
        this.nannyName = nannyName;
        this.nannyPhone = nannyPhone;
        this.nannyAddress = nannyAddress;
        this.trainId = trainId;
        this.trainPhone = trainPhone;
        this.trainName = trainName;
    }

    public Integer getNannyId() {
        return nannyId;
    }

    public void setNannyId(Integer nannyId) {
        this.nannyId = nannyId;
    }

    public String getNannyName() {
        return nannyName;
    }

    public void setNannyName(String nannyName) {
        this.nannyName = nannyName;
    }

    public String getNannyPhone() {
        return nannyPhone;
    }

    public void setNannyPhone(String nannyPhone) {
        this.nannyPhone = nannyPhone;
    }

    public String getNannyAddress() {
        return nannyAddress;
    }

    public void setNannyAddress(String nannyAddress) {
        this.nannyAddress = nannyAddress;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getTrainPhone() {
        return trainPhone;
    }

    public void setTrainPhone(String trainPhone) {
        this.trainPhone = trainPhone;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
}
