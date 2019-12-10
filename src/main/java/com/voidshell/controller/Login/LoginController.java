package com.voidshell.controller.Login;

import com.voidshell.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/index")
@Api(tags="登录管理")
public class LoginController {

    @ApiOperation(value="登录", notes="用户登录")
    @PostMapping("/login")
    public ResponseResult login(String username, String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        return ResponseResult.createComm(0,"logout","logout");
    }


    @ApiOperation(value="登出", notes="用户登出")
    @GetMapping("/logout")
    public ResponseResult logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ResponseResult.createComm(0,"logout","logout");
    }
}
