package com.ming.eurekaclient;

import com.ming.eurekaclient.serivce.IFactorySerivce;
import com.ming.eurekaclient.serivce.IOneStepStatckService;
import com.ming.eurekaclient.serivce.ISortService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public ISortService sortService() throws Exception {
        MyBeanFactory<Object> objectMyBeanFactory = new MyBeanFactory<>(applicationContext, ISortService.class);
        return  (ISortService)objectMyBeanFactory .getObject();
    }

    @Autowired
    public IOneStepStatckService oneStepStatckService() throws Exception {
        MyBeanFactory<Object> objectMyBeanFactory = new MyBeanFactory<>(applicationContext, IOneStepStatckService.class);
        return (IOneStepStatckService)objectMyBeanFactory.getObject();
    }

}
