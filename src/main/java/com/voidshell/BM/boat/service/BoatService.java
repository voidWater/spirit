package com.voidshell.BM.boat.service;

import com.alibaba.fastjson.JSONObject;
import com.voidshell.BM.boat.dao.WxBoatMapper;
import com.voidshell.BM.boat.dao.WxUserMapper;
import com.voidshell.BM.boat.pojo.WxBoat;
import com.voidshell.BM.boat.pojo.WxBoatExample;
import com.voidshell.BM.boat.pojo.WxUser;
import com.voidshell.BM.boat.pojo.WxUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BoatService {

    @Autowired
    WxUserMapper wxUserMapper;
    @Autowired
    WxBoatMapper wxBoatMapper;

    public void loginAndRegister(String result) {
        JSONObject json = JSONObject.parseObject(result);
        System.out.println(result);
        if(json.get("openid")!=null){
            WxUserExample wxUserExample = new WxUserExample();
            wxUserExample.createCriteria().andOpenidEqualTo(json.get("openid").toString());
            List<WxUser> userList= wxUserMapper.selectByExample(wxUserExample);
            if(userList.size()==0){
                WxUser user = new WxUser();
                user.setId(UUID.randomUUID().toString().replaceAll("-",""));
                user.setOpenid(json.get("openid").toString());
                wxUserMapper.insert(user);
            }
        }
        System.out.println(json.get("openid"));
    }

    public WxBoat createMarker(String openId,WxBoat boat) {
        boat.setId(UUID.randomUUID().toString().replaceAll("-",""));
        boat.setCreatedate(new Date());
        boat.setOpenid(openId);
        boat.setStatus("0");
        if(wxBoatMapper.insert(boat)==1){
            return boat;
        }else{
            return null;
        }
    }

    public List<WxBoat> getMarkers(String openId) {
        WxBoatExample wxBoatExample = new WxBoatExample();
        wxBoatExample.createCriteria().andOpenidEqualTo(openId).andStatusEqualTo("0");
        return wxBoatMapper.selectByExample(wxBoatExample);
    }

    public WxBoat updateMarker(WxBoat boat) {
        boat.setUpdatadate(new Date());
        if(wxBoatMapper.updateByPrimaryKey(boat)==1){
            return boat;
        }else{
            return null;
        }
    }

    public int delMarker(String id) {
        WxBoat boat = wxBoatMapper.selectByPrimaryKey(id);
        if(boat!=null){
            boat.setStatus("-1");
            return wxBoatMapper.updateByPrimaryKey(boat);
        }else{
            return 0;
        }
    }
}
