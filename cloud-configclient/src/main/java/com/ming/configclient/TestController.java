package com.ming.configclient;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panyanming on 2019/9/21.
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/from")
    public  String from() {
        return this.from;
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/send")
    @ResponseBody
    public String sendMessage(HttpServletRequest request) {
        rabbitTemplate.convertAndSend("spring-boot-exchange","foo.bar.baz","Hello from RabbitMQ!");
        return "发送成功";
    }

}
