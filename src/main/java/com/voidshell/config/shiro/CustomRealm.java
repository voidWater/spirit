package com.voidshell.config.shiro;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class CustomRealm extends AuthorizingRealm {



    @Autowired
    ShiroSampleDao shiroSampleDao;
    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) super.getAvailablePrincipal(principals);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = shiroSampleDao.getRolesByUsername(username);
        authorizationInfo.setRoles(roles);
        roles.forEach(role -> {
            Set<String> permissions = this.shiroSampleDao.getPermissionsByRole(role);
            authorizationInfo.addStringPermissions(permissions);
        });
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = this.shiroSampleDao.getPasswordByUsername(username);
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}