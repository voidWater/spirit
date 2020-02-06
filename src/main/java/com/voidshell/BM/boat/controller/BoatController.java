package com.voidshell.BM.boat.controller;

import com.voidshell.BM.boat.pojo.WxBoat;
import com.voidshell.BM.boat.service.BoatService;
import com.voidshell.common.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("boat")
public class BoatController {

    @Autowired
    BoatService boatService;

    @RequestMapping("getOpenId")
    public String getOpenId(String code) throws Exception {
        String AppID = "wx98a93887912c7a82";
        String AppSecret = "e96c212832d63423e7256364528ad40d";//这两个都可以从微信公众平台中查找
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="
                + AppID + "&secret=" + AppSecret + "&js_code="
                + code + "&grant_type=authorization_code";
        URL reqURL = new URL(url);
        HttpsURLConnection openConnection = (HttpsURLConnection) reqURL.openConnection();
        openConnection.setConnectTimeout(10000);
        openConnection.connect();
        InputStream in = openConnection.getInputStream();

        StringBuilder builder = new StringBuilder();
        BufferedReader bufreader = new BufferedReader(new InputStreamReader(in));
        for (String temp = bufreader.readLine(); temp != null; temp = bufreader.readLine()) {
            builder.append(temp);
        }

        String result = builder.toString();
        in.close();
        openConnection.disconnect();
        boatService.loginAndRegister(result);
        return result;//result就是包含openid的键值对，返回给小程序前端即可
    }

    /**
     * 获取个人标记
     * @param openId
     * @return
     */
    @RequestMapping("getMarkers")
    public ResponseResult getMarkers(String openId){
        List<WxBoat> list= boatService.getMarkers(openId);
        return ResponseResult.createList(0,"success","成功",list.size(),list);
    }

    public ResponseResult getPublicMarkers(){
        return null;
    }

    /**
     * 创建标记
     * @param openId
     * @param boat
     * @return
     */
    @RequestMapping("createMarker")
    public ResponseResult createMarker(String openId,@RequestBody WxBoat boat){
        boat = boatService.createMarker(openId,boat);
        if(boat!=null){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("marker",boat);
            return ResponseResult.createData(0,"success","success",map);
        }else{
            return ResponseResult.createComm(1,"error","保存标记失败");
        }
    }

    /**
     * 更新marker
     * @param boat
     * @return
     */
    @RequestMapping("updateMarker")
    public ResponseResult updateMarker(@RequestBody WxBoat boat){
        boat = boatService.updateMarker(boat);
        if(boat!=null){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("marker",boat);
            return ResponseResult.createData(0,"success","success",map);
        }else{
            return ResponseResult.createComm(1,"error","修改标记失败");
        }
    }

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @RequestMapping("delMarker")
    public ResponseResult delMarker(String id){
        if(boatService.delMarker(id)==1){
            return ResponseResult.createComm(0,"success","删除成功");
        }else{
            return ResponseResult.createComm(1,"error","删除失败");
        }
    }
}
