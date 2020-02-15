package com.kk.springboot.config;

/*
@author kzj
@date 2019/12/18 - 21:38
*/

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    后台监控地址：http://localhost:8080/druid/index.html
*/

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控：web.xml  ServletRegistrationBean
    //因为SprinBboot内置了servlet容器，所以没有web.xml，替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要有人登陆，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        //登录的key是固定的loginUsername、loginPassword
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123");

        //允许谁可以访问
        //为空的话就是所有都可访问
        initParameters.put("allow", "localhost");

        //禁止谁访问
//        initParameters.put("kzj", "ip地址");//禁止本ip访问

        bean.setInitParameters(initParameters);//设置初始化参数
        return bean;
    }


    //filter
    //配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        Map<String, String> initParameters = new HashMap<>();

        //这些东西不进行统计
        initParameters.put("exclusions", "*.js,*.css,/druid/*");

        //配置filter过滤所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));

        //可以过滤那些请求呢？
        bean.setInitParameters(initParameters);

        return bean;
    }





}
