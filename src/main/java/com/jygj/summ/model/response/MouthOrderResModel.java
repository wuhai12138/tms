package com.jygj.summ.model.response;

import java.util.List;

/**
 * Created by jygj_7500 on 2017/7/20.
 */
public class MouthOrderResModel {
    private List<MouthOrderModel> list;
    private Integer orders;

    public List<MouthOrderModel> getList() {
        return list;
    }

    public void setList(List<MouthOrderModel> list) {
        this.list = list;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}
