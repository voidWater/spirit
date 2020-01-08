package com.voidshell.BM.lotte.controller;

import com.voidshell.BM.lotte.pojo.WxLotte;
import com.voidshell.BM.lotte.pojo.WxParticipant;
import com.voidshell.BM.lotte.service.LotteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/lotte")
public class LotteController {

    @Autowired
    LotteService lotteService;

    /**
     * 创建抽奖
     * @param wxLotte
     * @return
     */
    @PostMapping("create")
    public String create(@RequestBody WxLotte wxLotte){
        if(lotteService.createLotte(wxLotte)==1){
            return "1";
        }else{
            return "0";
        }
    }

    /**
     * 修改抽奖
     * @param wxLotte
     * @return
     */
    @PostMapping("update")
    public String edit(@RequestBody WxLotte wxLotte){
        if(lotteService.updateLotte(wxLotte)==1){
            return "1";
        }else{
            return "0";
        }
    }

    /**
     * 获取抽奖码
     * @param lotteId
     * @return
     */
    @GetMapping("getCode")
    public String getCode(String lotteId){
        return lotteService.getCode(lotteId);
    }

    /**
     * 获取我发起的抽奖
     * @param openId
     * @return
     */
    @GetMapping("list")
    public List<WxLotte> list(String openId){
        return lotteService.selectByOpenId(openId);
    }

    /**
     * 获取我加入的抽奖
     * @param openId
     * @return
     */
    @GetMapping("listJoin")
    public List<WxLotte> listJoin(String openId){
        return lotteService.selectJoinByOpenId(openId);
    }

    /**
     * 获取抽奖
     * @param id
     * @return
     */
    @GetMapping("get")
    public WxLotte get(String id){
        return lotteService.getLotteById(id);
    }

    /**
     * 获取参与人
     * @param id
     * @return
     */
    @GetMapping("getP")
    public List<WxParticipant> getP(String id){
        return lotteService.getP(id);
    }

    @GetMapping("del")
    public String del(String id){
        return lotteService.delLotte(id);
    }

    @GetMapping("delItem")
    public String delItem(String id){
        return lotteService.delLotteItem(id);
    }

    /**
     * 参与抽奖
     * @param openId
     * @param nickName
     * @param avaUrl
     * @param code
     * @return
     */
    @GetMapping("join")
    public String join(String openId,String nickName,String avaUrl,String code){
        return lotteService.join(openId,nickName,avaUrl,code);
    }

    /**
     * 开奖
     * @param openId
     * @param lotteId
     * @param lotteItemId
     * @param type
     * @param status
     * @return
     */
    @GetMapping("openLotte")
    public String run(String openId,String lotteId,String lotteItemId,String type,int status){
        return lotteService.operateLotte( openId, lotteId, lotteItemId, type, status);
    }

    /**
     * 获取openid
     * @param code
     * @return
     * @throws Exception
     */
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
        return result;//result就是包含openid的键值对，返回给小程序前端即可
    }

    /**
     * 获取获奖者
     * @param lotteId
     * @param lotteItemId
     * @return
     */
    @RequestMapping("getLuckPar")
    public List<WxParticipant> getLuckPar(String lotteId,String lotteItemId){
        return lotteService.getLuckPar(lotteId,lotteItemId);
    }
    @RequestMapping("test")
    public String test(){
        return "123123123123123";
    }
}
