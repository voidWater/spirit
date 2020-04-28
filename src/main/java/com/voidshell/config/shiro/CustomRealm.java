package com.voidshell.config.shiro;


import com.voidshell.pojo.userManage.VsUmUser;
import com.voidshell.service.userManage.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);
        return info;
    }

    /**
     *
     * @param authenticationToken
     * @return
     * @throws AccountException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AccountException {
        System.out.println("-------身份认证方法--------");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码

        VsUmUser user= userService.getUserByName(userName);
        if (user == null) {
            throw new AccountException("用户名不正确");
        }else if(user.getPassword().equals(userPwd)){
            return new SimpleAuthenticationInfo(userName, user.getPassword(),getName());
        }else{
            throw new AccountException("密码不正确");
        }
    }

//    //如果项目中用到了事物，@Autowired注解会使事物失效，可以自己用get方法获取值
//    @Autowired
//    ShiroSampleDao shiroSampleDao;
//    /**
//     * 授权
//     * @param principals
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String username = (String) super.getAvailablePrincipal(principals);
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        Set<String> roles = shiroSampleDao.getRolesByUsername(username);
//        authorizationInfo.setRoles(roles);
//        roles.forEach(role -> {
//            Set<String> permissions = this.shiroSampleDao.getPermissionsByRole(role);
//            authorizationInfo.addStringPermissions(permissions);
//        });
//        return authorizationInfo;
//    }
//
//    /**
//     * 认证
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String username = token.getUsername();
//        String password = this.shiroSampleDao.getPasswordByUsername(username);
//        return new SimpleAuthenticationInfo(username, password, getName());
//    }
}
