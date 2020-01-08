package com.voidshell.controller.userManage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("user")
@Api(tags="用户管理")
public class UserManageController {

    //@Resource
    //private UserManageService userManageService;

//    @GetMapping("/login")
//    public void login(String username, String password) {
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        token.setRememberMe(true);
//        Subject currentUser = SecurityUtils.getSubject();
//        currentUser.login(token);
//    }
//
//    @GetMapping("/logout")
//    public void logout() {
//        Subject currentUser = SecurityUtils.getSubject();
//        currentUser.logout();
//    }
//
//    @GetMapping("/read")
//    public void read() {
//        //return this.userManageService.read();
//    }
//
//    @GetMapping("/write")
//    public void write() {
//        //return this.userManageService.write();
//    }

}
