package com.ming.eurekaclient.config;


//public class DruidConfig {}

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by panyanming on 2019/10/30.
 */
@Configuration
//@AutoConfigureAfter({DruidProperty.class})
//@EnableTransactionManagement(proxyTargetClass = true)
public class DruidConfig {

//    @javax.annotation.Resource
//    DruidProperty druidproperty;

    @Bean(name = "writeDataSource")
    @Primary
    public DataSource druid() {
//        return  new DruidDataSource();

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:sqlserver://10.168.100.104:1433; DatabaseName=BreakRulesLookup");
        dataSource.setUsername("sa");
        dataSource.setPassword("AutoDbps123");
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setInitialSize(0);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(25200000);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(1800);
        dataSource.setLogAbandoned(true);

        try {
            dataSource.setFilters("config,stat,log4j2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //dataSource.setConnectionProperties(druidproperty.getConnectionProperties());
        return dataSource;
    }


    @Bean(name = "readDataSource")
    public DataSource readDruid() {
//        return  new DruidDataSource();

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:sqlserver://10.168.100.104:1433; DatabaseName=BreakRulesLookup");
        dataSource.setUsername("sa");
        dataSource.setPassword("AutoDbps123");
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setInitialSize(0);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(25200000);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(1800);
        dataSource.setLogAbandoned(true);

        try {
            dataSource.setFilters("config,stat,log4j2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //dataSource.setConnectionProperties(druidproperty.getConnectionProperties());
        return dataSource;
    }

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(@Qualifier("writeDataSource") DataSource test1DataSource,
                                        @Qualifier("readDataSource") DataSource test2DataSource) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.DataBaseType.TEST01, test1DataSource);
        targetDataSource.put(DataSourceType.DataBaseType.TEST02, test2DataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(test1DataSource);
        return dataSource;
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory test1SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapperxml/**/*.xml"));
        return bean.getObject();
    }

    //配置Druid的监控
    //1、配置一个管理后台的Servlet
    @Bean
    @SuppressWarnings(value = {"unchecked"})
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();

        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123!@#QWE*()");
        initParams.put("allow", "");//默认就是允许所有访问
        initParams.put("deny", "192.168.15.21");

        bean.setInitParameters(initParams);
        return bean;
    }

}
