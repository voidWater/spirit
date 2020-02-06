package com.voidshell.BM.boat.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class WxBoat {
    private String id;

    private String openid;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String name;

    private String des;

    private String imglist;

    private String status;

    private Date createdate;

    private Date updatadate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImglist() {
        return imglist;
    }

    public void setImglist(String imglist) {
        this.imglist = imglist;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatadate() {
        return updatadate;
    }

    public void setUpdatadate(Date updatadate) {
        this.updatadate = updatadate;
    }
}