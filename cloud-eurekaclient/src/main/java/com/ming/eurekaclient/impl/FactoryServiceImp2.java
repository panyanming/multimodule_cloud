package com.ming.eurekaclient.impl;

import com.ming.eurekaclient.serivce.IFactorySerivce;
import org.springframework.stereotype.Component;

/**
 * Created by panyanming on 2019/10/29.
 */
@Component
public class FactoryServiceImp2 implements IFactorySerivce {
    @Override
    public boolean verify(Integer condition) {
        return condition>5;
    }

    @Override
    public void facotryTest() {
        System.out.println("factory impl2");
    }
}
