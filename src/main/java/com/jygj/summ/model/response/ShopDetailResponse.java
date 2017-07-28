package com.jygj.summ.model.response;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;

/**
 * Created by jygj_7500 on 2017/7/25.
 */
public class ShopDetailResponse {

    /** 门店id */
    @TableId(value = "shop_id", type = IdType.AUTO)
    private Integer shopId;

    /** 门店名称 */
    @TableField(value = "shop_name")
    private String shopName;

    /** 联系电话 */
    @TableField(value = "shop_phone")
    private String shopPhone;

    /** 门店地址 */
    @TableField(value = "shop_address")
    private String shopAddress;

    /** 移动电话 */
    @TableField(value = "mobile_phone")
    private String mobilePhone;

    /**  */
    private String paycode;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPaycode() {
        return paycode;
    }

    public void setPaycode(String paycode) {
        this.paycode = paycode;
    }
}
