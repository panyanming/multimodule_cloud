package com.ming.eurekaclient;

import com.ming.eurekaclient.serivce.IFactorySerivce;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by panyanming on 2019/10/29.
 */
@Configuration
public class FactoryBeanAppConfig {

    @Bean
    public MyBeanFactory factoryServiceProxy(ApplicationContext applicationContext) {
        return new MyBeanFactory(applicationContext, IFactorySerivce.class);
    }

    @Bean
    @Primary
    public IFactorySerivce factorySerivce(MyBeanFactory factoryServiceProxy) throws Exception {
        return (IFactorySerivce) factoryServiceProxy.getObject();
    }
}
