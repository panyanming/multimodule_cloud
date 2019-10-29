package com.ming.eurekaclient.controller;

import com.ming.eurekaclient.MyBeanFactory;
import com.ming.eurekaclient.serivce.IFactorySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by panyanming on 2019/10/29.
 */
@RequestMapping(value = "factory")
@Controller
public class FactoryController {

    @Autowired
    IFactorySerivce factorySerivce;

    @RequestMapping(value = "testFactory.do")
    @ResponseBody
    public void testFactoryBean(HttpServletRequest request) {
        factorySerivce.excecute(1);
    }
}
