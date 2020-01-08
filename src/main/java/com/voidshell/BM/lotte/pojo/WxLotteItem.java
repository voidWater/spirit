package com.voidshell.BM.lotte.pojo;

import java.util.Date;

public class WxLotteItem {
    private String id;

    private String lotteid;

    private String name;

    private String des;

    private Integer num;

    private String fmurl;

    private Date createtime;

    private Date updatetime;

    private String type;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLotteid() {
        return lotteid;
    }

    public void setLotteid(String lotteid) {
        this.lotteid = lotteid;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getFmurl() {
        return fmurl;
    }

    public void setFmurl(String fmurl) {
        this.fmurl = fmurl;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}