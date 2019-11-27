package com.ming.eurekaclient.config;

public class MybatisConfig{}

//@Configuration
//@AutoConfigureAfter({DruidProperty.class})
//@EnableTransactionManagement(proxyTargetClass = true)
//public class MybatisConfig implements TransactionManagementConfigurer {//implements TransactionManagementConfigurer
//
//    private static Logger logger = LoggerFactory.getLogger(MybatisConfig.class.getName());
//
//    @javax.annotation.Resource
//    DruidProperty druidproperty;
//    @javax.annotation.Resource
//    PlatformTransactionManager transactionManager;
//
//    @Bean(initMethod = "init", destroyMethod = "close")
//    @Primary
//    public DruidDataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(druidproperty.getUrl());
//        dataSource.setUsername(druidproperty.getUsername());
//        dataSource.setPassword(druidproperty.getPassword());
//        dataSource.setDriverClassName(druidproperty.getDriverClassName());
//        dataSource.setInitialSize(druidproperty.getInitialSize());
//        dataSource.setMaxActive(druidproperty.getMaxActive());
//        dataSource.setMinIdle(druidproperty.getMinIdle());
//        dataSource.setMaxWait(druidproperty.getMaxWait());
//        dataSource.setValidationQuery(druidproperty.getValidationQuery());
//        dataSource.setTestOnBorrow(druidproperty.isTestOnBorrow());
//        dataSource.setTestOnReturn(druidproperty.isTestOnReturn());
//        dataSource.setTestWhileIdle(druidproperty.isTestWhileIdle());
//        dataSource.setTimeBetweenEvictionRunsMillis(druidproperty.getTimeBetweenEvictionRunsMillis());
//        dataSource.setMinEvictableIdleTimeMillis(druidproperty.getMinEvictableIdleTimeMillis());
////        dataSource.setMaxEvictableIdleTimeMillis();
//        dataSource.setRemoveAbandoned(druidproperty.isRemoveAbandoned());
//        dataSource.setRemoveAbandonedTimeout(druidproperty.getRemoveAbandonedTimeout());
//        dataSource.setLogAbandoned(druidproperty.isLogAbandoned());
//
//        try {
//            dataSource.setFilters(druidproperty.getFilters());
//        } catch (SQLException e) {
//            e.printStackTrace();
//            logger.error("Druid URL过滤设置失败", e);
//        }
//        dataSource.setConnectionProperties(druidproperty.getConnectionProperties());
//
////        registJdbcConnection(dataSource);
//        return dataSource;
//    }
//
//    /**
//     * 注册一个StatViewServlet
//     *
//     * @return
//     */
//    @Bean
//    public ServletRegistrationBean druidStatViewServlet() {
//        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        //添加初始化参数：initParams
//        //白名单：
//        servletRegistrationBean.addInitParameter("allow", druidproperty.getAllow());
////        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
////        servletRegistrationBean.addInitParameter("deny","192.168.1.73");
//        //登录查看信息的账号密码.
//        servletRegistrationBean.addInitParameter("loginUsername", druidproperty.getLoginUsername());
//        servletRegistrationBean.addInitParameter("loginPassword", druidproperty.getLoginPassword());
//        //是否能够重置数据.
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//    }
//
//    /**
//     * 注册一个：filterRegistrationBean
//     *
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean druidStatFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        //添加过滤规则.
//        filterRegistrationBean.addUrlPatterns("/*");
//        //添加不需要忽略的格式信息.
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return transactionManager;
//    }
//
////    private JdbcConnection registJdbcConnection(DataSource dataSource){
////
////        return new JdbcConnection(dataSource);
////
////    }
//}
