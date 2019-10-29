package com.ming.eurekaclient;

import com.ming.eurekaclient.serivce.ISPI;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by panyanming on 2019/10/29.
 */
public class MyBeanFactory<T> implements FactoryBean<T> {
    private Class<? extends ISPI> spiClz;
    private List<ISPI> list;

    public MyBeanFactory(ApplicationContext applicationContext, Class<? extends ISPI> clz) {
        this.spiClz = clz;
        Map<String, ? extends ISPI> beansOfType = applicationContext.getBeansOfType(spiClz);
        list = new ArrayList<>(beansOfType.values());
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getObject() throws Exception {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                for (ISPI ispi : list) {
                    if (ispi.verify(args[0])) {
                        return method.invoke(ispi,args);
                    }
                }
                throw new Exception("no spi server can execute! spiList: " + list);
            }
        };

        return (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{spiClz}, invocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return spiClz;
    }
}
