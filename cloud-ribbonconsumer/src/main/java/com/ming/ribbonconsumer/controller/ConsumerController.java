package com.ming.ribbonconsumer.controller;

import com.ming.ribbonconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by panyanming on 2019/9/9.
 */


@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value="/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.helloService();
    }
}
