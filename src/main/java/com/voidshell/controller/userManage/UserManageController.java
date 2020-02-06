package com.voidshell.controller.userManage;

import com.voidshell.common.ResponseResult;
import com.voidshell.pojo.userManage.VsUmDepart;
import com.voidshell.pojo.userManage.VsUmUser;
import com.voidshell.service.userManage.OrgService;
import com.voidshell.service.userManage.UserService;
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
import java.util.Map;

@RestController
@RequestMapping("user")
@Api(tags="用户管理")
public class UserManageController {

    @Autowired
    private OrgService orgService;
    @Autowired
    private UserService userService;

    @PostMapping("/addDepart")
    public ResponseResult addDepart(String code,String name,String des){
        System.out.println(code);
        System.out.println(name);
        System.out.println(des);
        if(orgService.addDepart(code,name,des)==1){
            return ResponseResult.createComm(0,"success","成功");
        }else{
            return ResponseResult.createComm(1,"fail","失败");
        }
    }
    @RequestMapping("/listDepart")
    public ResponseResult getDepart(){
        List<VsUmDepart>list= orgService.list();
        return ResponseResult.createList(0,"success","成功",list.size(),list);
    }

    /**
     * 新增用户
     * @return
     */
    public ResponseResult addUser(VsUmUser vsUmUser){
        return userService.createUser(vsUmUser);
    }

    /**
     *
     * @return
     */
    public ResponseResult listUser(){
        List<VsUmUser>list= userService.list();
        return ResponseResult.createList(0,"success","成功",list.size(),list);
    }

}
