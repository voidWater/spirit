package com.voidshell.BM.acBook.controller;

import com.voidshell.BM.acBook.Const;
import com.voidshell.BM.acBook.HttpResult;
import com.voidshell.BM.acBook.pojo.User;
import com.voidshell.BM.acBook.service.BookService;
import com.voidshell.BM.acBook.service.UserService;
import com.voidshell.common.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("login")
    public ResponseResult login(String code){
        return null;
    }
    @GetMapping("addSubUser")
    public HttpResult addSubUser(String bookId,String subUserId, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(!bookService.checkUserAndBook(bookId,user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        if(userService.addSubUser(bookId,user.getId(),subUserId,"")==1){
            return HttpResult.success();
        }
        return HttpResult.error();
    }
    @GetMapping("delSubUser")
    public HttpResult delSubUser(String bookId,String subUserId,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(!bookService.checkUserAndBook(bookId,user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        if(userService.delSubUser(bookId,user.getId(),subUserId)==1){
            return HttpResult.success();
        }
        return HttpResult.error();
    }
    public HttpResult getAllSubUser(String bookId,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(!bookService.checkUserAndBook(bookId,user.getId())||bookService.checkSubUserAndBook(bookId,user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        List<User> list = userService.getAllSubUser(bookId);
        if(list==null){
            return HttpResult.success(""+list.size(),list);
        }
        return HttpResult.error();
    }
    @PostMapping("changeSubUserAuth")
    public HttpResult changeSubUserAuth(){
        return null;
    }
}
