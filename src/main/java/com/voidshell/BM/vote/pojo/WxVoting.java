package com.voidshell.BM.vote.pojo;

import java.util.Date;

public class WxVoting {
    private String id;

    private String voteId;

    private String openid;

    private String voteItemId;

    private Date votedate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getVoteItemId() {
        return voteItemId;
    }

    public void setVoteItemId(String voteItemId) {
        this.voteItemId = voteItemId;
    }

    public Date getVotedate() {
        return votedate;
    }

    public void setVotedate(Date votedate) {
        this.votedate = votedate;
    }
}