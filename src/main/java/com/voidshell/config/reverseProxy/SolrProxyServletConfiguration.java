package com.voidshell.config.reverseProxy;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@Configuration
public class SolrProxyServletConfiguration implements EnvironmentAware {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(), "/love/*");
        servletRegistrationBean.addInitParameter("targetUri", "http://192.168.168.70:8083/");
        servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, "false");
        return servletRegistrationBean;
    }



    @Override
    public void setEnvironment(Environment environment) {

    }
}
