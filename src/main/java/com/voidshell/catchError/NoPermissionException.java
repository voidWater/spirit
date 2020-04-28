package com.voidshell.catchError;

import com.voidshell.common.ResponseResult;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class NoPermissionException {
    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public String handleShiroException(Exception ex) {
        return "无权限";
    }
    @ResponseBody
    @ExceptionHandler(AccountException.class)
    public ResponseResult AuthorizationException(Exception ex) {
        return ResponseResult.createComm(-1,"loginError","用户登录失败,"+ex.getMessage());
    }
}
