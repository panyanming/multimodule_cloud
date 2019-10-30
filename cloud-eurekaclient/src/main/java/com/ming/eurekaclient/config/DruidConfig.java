package com.ming.eurekaclient.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by panyanming on 2019/10/30.
 */
@Configuration
@AutoConfigureAfter({DruidProperty.class})
@EnableTransactionManagement(proxyTargetClass = true)
public class DruidConfig {

    @javax.annotation.Resource
    DruidProperty druidproperty;

    @Bean
    public DataSource druid(){
//        return  new DruidDataSource();

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(druidproperty.getUrl());
        dataSource.setUsername(druidproperty.getUsername());
        dataSource.setPassword(druidproperty.getPassword());
        dataSource.setDriverClassName(druidproperty.getDriverClassName());
        dataSource.setInitialSize(druidproperty.getInitialSize());
        dataSource.setMaxActive(druidproperty.getMaxActive());
        dataSource.setMinIdle(druidproperty.getMinIdle());
        dataSource.setMaxWait(druidproperty.getMaxWait());
        dataSource.setValidationQuery(druidproperty.getValidationQuery());
        dataSource.setTestOnBorrow(druidproperty.isTestOnBorrow());
        dataSource.setTestOnReturn(druidproperty.isTestOnReturn());
        dataSource.setTestWhileIdle(druidproperty.isTestWhileIdle());
        dataSource.setTimeBetweenEvictionRunsMillis(druidproperty.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidproperty.getMinEvictableIdleTimeMillis());
        dataSource.setRemoveAbandoned(druidproperty.isRemoveAbandoned());
        dataSource.setRemoveAbandonedTimeout(druidproperty.getRemoveAbandonedTimeout());
        dataSource.setLogAbandoned(druidproperty.isLogAbandoned());

        try {
            dataSource.setFilters(druidproperty.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dataSource.setConnectionProperties(druidproperty.getConnectionProperties());
        return dataSource;
    }

    //配置Druid的监控
    //1、配置一个管理后台的Servlet
    @Bean
    @SuppressWarnings(value = {"unchecked"})
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();

        initParams.put("loginUsername",druidproperty.getLoginUsername());
        initParams.put("loginPassword",druidproperty.getLoginPassword());
        initParams.put("allow","");//默认就是允许所有访问
        initParams.put("deny","192.168.15.21");

        bean.setInitParameters(initParams);
        return bean;
    }

}
