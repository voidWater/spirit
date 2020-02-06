package com.voidshell.controller.userManage;


import com.voidshell.common.ResponseResult;
import com.voidshell.pojo.UserBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/auth2")
@Api(tags="登录管理")
public class LoginController {

    @PostMapping("/login2")
    public Map<String,Object> AntLogin(String username, String  password ){
        Map<String ,Object> rm = new HashMap<>();
        rm.put("id",UUID.randomUUID().toString());
        rm.put("name","123");
        rm.put("password","");
        rm.put("avatar","https://gw.alipayobjects.com/zos/rmsportal/jZUIxmJycoymBprLOUbT.png");
        rm.put("status",1);
        rm.put("telephone","");
        rm.put("lastLoginIp","27.154.74.117");
        rm.put("lastLoginTime","1534837621348");
        rm.put("creatorId","admin");
        rm.put("createTime","1497160610259");
        rm.put("deleted",0);
        rm.put("roleId","admin");
        rm.put("lang","zh-CN");
        rm.put("token","4291d7da9005377ec9aec4a71ea837f");

        Map<String ,Object> rm3 = new HashMap<>();
        rm3.put("message","");
        rm3.put("code","200");
        rm3.put("result",rm);
        Map<String ,Object> rm2 = new HashMap<>();
        rm2.put("Custom-Header",UUID.randomUUID().toString());
        rm3.put("_headers",rm2);
        return rm3;
    }


    @ApiOperation(value="登录", notes="用户登录")
    @PostMapping("/login12121")
    public ResponseResult login(String username, String password, HttpSession session, HttpServletRequest request){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();

        UserBO user = new UserBO();
        user.setLoginDate(new Date());
        user.setIp(request.getRemoteAddr());
        session.setAttribute("user",user);

        try{
            currentUser.login(token);
            return ResponseResult.createComm(0,"login","login");
        }catch(IncorrectCredentialsException e){
            return ResponseResult.createComm(1,"logout","logout");
        }
    }

    @GetMapping("get")
    public ResponseResult getUsername(HttpSession session){
        Subject currentUser = SecurityUtils.getSubject();
        return ResponseResult.createComm(1,"user",session.getAttribute("user").toString());
    }



    @ApiOperation(value="登出", notes="用户登出")
    @GetMapping("/logout")
    public ResponseResult logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ResponseResult.createComm(0,"logout","logout");
    }
}
