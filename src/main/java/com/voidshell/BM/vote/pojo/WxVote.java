package com.voidshell.BM.vote.pojo;

import java.util.Date;

public class WxVote {
    private String id;

    private String openid;

    private Integer type;

    private String title;

    private String des;

    private Date datetime;

    private Integer anoflag;

    private Integer limitflag;

    private String grou;

    private Integer scope;

    private Date createdate;

    private String[] list;

    public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getAnoflag() {
        return anoflag;
    }

    public void setAnoflag(Integer anoflag) {
        this.anoflag = anoflag;
    }

    public Integer getLimitflag() {
        return limitflag;
    }

    public void setLimitflag(Integer limitflag) {
        this.limitflag = limitflag;
    }

    public String getGrou() {
        return grou;
    }

    public void setGrou(String grou) {
        this.grou = grou;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}