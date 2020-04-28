package com.voidshell.controller.AntAdmin;

import com.voidshell.common.ResponseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AntLoginController {
    @RequestMapping("/nologin")
    public ResponseResult noLogin(){
        return ResponseResult.createComm(0,"nologin","用户没有登录，请先登录");
    }
    @PostMapping("/login")
    public Map<String,Object> login(String username, String password, HttpSession session) throws Exception{

        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);


        Map<String ,Object> resule = new HashMap<>();
        resule.put("id",UUID.randomUUID().toString());
        resule.put("name","123");
        resule.put("password","");
        resule.put("avatar","https://gw.alipayobjects.com/zos/rmsportal/jZUIxmJycoymBprLOUbT.png");
        resule.put("status",1);
        resule.put("telephone","");
//        resule.put("lastLoginIp","27.154.74.117");
//        resule.put("lastLoginTime","1534837621348");
//        resule.put("creatorId","admin");
//        resule.put("createTime","1497160610259");
//        resule.put("deleted",0);
        resule.put("roleId","admin");
        resule.put("lang","zh-CN");
        resule.put("token","4291d7da9005377ec9aec4a71ea837f");

        session.setAttribute("userToken","4291d7da9005377ec9aec4a71ea837f");
        Map<String ,Object> ch = new HashMap<>();
        ch.put("Custom-Header",UUID.randomUUID().toString());


        Map<String ,Object> responseResult = new HashMap<>();
        responseResult.put("message","");
        responseResult.put("code","200");
        responseResult.put("result",resule);
        responseResult.put("_headers",ch);
        return responseResult;
    }

    @PostMapping("/logout")
    public Map<String,Object> logout(HttpSession session){
        SecurityUtils.getSubject().logout();
        Map<String ,Object> responseResult = new HashMap<>();
        responseResult.put("message","注销成功");
        responseResult.put("code","200");
        responseResult.put("result","{}");
        return responseResult;
    }

    @RequestMapping("/403")
    public String noper(){
        return "403";
    }
}
