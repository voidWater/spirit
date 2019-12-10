package com.voidshell.controller.userManage;

import com.voidshell.pojo.User;
import com.voidshell.service.userManage.UserManageService;

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
    ///////////////
    @Autowired
    private UserManageService userManageService;

    @ApiOperation(value="创建用户基本信息", notes="创建用户基本信息")
    @PostMapping("/createUser")
    public User createUser(HttpSession session , User user){
        return userManageService.createUser(user);
    }
    @ApiOperation(value="查看用户列表", notes="查看用户列表")
    @GetMapping("/viewUser")
    public List<User> viewUser(HttpSession session , User user){
        return userManageService.viewUser(user);
    }
    @ApiOperation(value="修改用户信息", notes="修改用户信息")
    @PutMapping("/updateUser")
    public User updateUser(HttpSession session , User user){
        return userManageService.updateUser(user);
    }
    @ApiOperation(value="获取用户", notes="获取用户")
    @GetMapping("/user/{id}")
    public User getUser(String id){
        return userManageService.getUser(id);
    }
    @ApiOperation(value="删除用户", notes="删除用户")
    @DeleteMapping("/delUser/{id}")
    public String delUser(HttpSession session ,String id){
        return userManageService.delUser(id);
    }
}
