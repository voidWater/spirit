package com.voidshell.config.shiro;


import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

//@Configuration
public class ShiroConfig {
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(customRealm());
        return defaultSecurityManager;
    }
    @Bean
    public CustomRealm customRealm() {
        CustomRealm customRealm = new CustomRealm();
        return customRealm;
    }
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/auth/nologin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/auth/403");
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/auth/**", "anon");
//        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/", "anon");
//        filterChainDefinitionMap.put("/front/**", "anon");
//        filterChainDefinitionMap.put("/api/**", "anon");
//        filterChainDefinitionMap.put("/admin/**", "authc");
//        filterChainDefinitionMap.put("/user/**", "authc");
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }




//    /**
//     * 认证和授权realm(这个需要自己去实现，账号密码校验；认证权限等)
//     * @return
//     */
//    @Bean
//    public CustomRealm customRealm() {
//        return new CustomRealm();
//    }
//
//    /**
//     * 管理realm(后期使用redis可能会用到)
//     * @param customRealm
//     * @return
//     */
//    @Bean
//    public DefaultWebSecurityManager defaultWebSecurityManager(CustomRealm customRealm) {
//        DefaultWebSecurityManager  securityManager = new DefaultWebSecurityManager ();
//        securityManager.setRealm(customRealm);
//        return securityManager;
//    }
//
//    /**
//     * 自定义拦截规则
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
//
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        // 没有登陆的用户只能访问登陆页面
//        shiroFilterFactoryBean.setLoginUrl("/auth/login");
//        // 登录成功后要跳转的链接
////        shiroFilterFactoryBean.setSuccessUrl("/auth/index");
////        // 未授权界面; ----这个配置了没卵用，具体原因想深入了解的可以自行百度
////        //shiroFilterFactoryBean.setUnauthorizedUrl("/auth/403");
////        //自定义拦截器
////        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
////        //限制同一帐号同时在线的个数。
////        filtersMap.put("kickout", kickoutSessionControlFilter());
////        shiroFilterFactoryBean.setFilters(filtersMap);
////        // 权限控制map.
////        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
////        filterChainDefinitionMap.put("/css/**", "anon");
////        filterChainDefinitionMap.put("/js/**", "anon");
////        filterChainDefinitionMap.put("/img/**", "anon");
////        filterChainDefinitionMap.put("/auth/login", "anon");
////        filterChainDefinitionMap.put("/auth/logout", "logout");
////        filterChainDefinitionMap.put("/auth/kickout", "anon");
////        filterChainDefinitionMap.put("/**", "authc,kickout");
////        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * Shiro生命周期处理器
//     */
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
}
