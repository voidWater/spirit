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
import javax.websocket.Session;
import java.util.Date;

@RestController
@RequestMapping("/index")
@Api(tags="登录管理")
public class LoginController {


    @ApiOperation(value="登录", notes="用户登录")
    @PostMapping("/login")
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
