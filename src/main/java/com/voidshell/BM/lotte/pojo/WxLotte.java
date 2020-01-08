package com.voidshell.BM.lotte.pojo;

import java.util.Date;
import java.util.List;

public class WxLotte {
    private String id;

    private String openid;

    private String title;

    private String des;

    private Date datatime;

    private Date createtime;

    private Date updatetime;

    private String grou;

    private String scope;

    private String fmurl;

    private String code;

    private Integer status;

    private List<WxLotteItem> list;

    public List<WxLotteItem> getList() {
        return list;
    }

    public void setList(List<WxLotteItem> list) {
        this.list = list;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
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

    public String getGrou() {
        return grou;
    }

    public void setGrou(String grou) {
        this.grou = grou;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getFmurl() {
        return fmurl;
    }

    public void setFmurl(String fmurl) {
        this.fmurl = fmurl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}