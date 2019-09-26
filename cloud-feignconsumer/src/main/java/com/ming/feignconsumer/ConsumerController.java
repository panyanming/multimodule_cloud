package com.ming.feignconsumer;

import com.ming.helloapi2.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by panyanming on 2019/9/10.
 */

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value="/feign-consumer",method = RequestMethod.GET)
    public String  helloConsumer() {
        return helloService.hello();
    }


    @RequestMapping(value="/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("didi")).append("\n");
        sb.append(helloService.hello("didi",30)).append("\n");
        sb.append(helloService.hello(new User("didi",30))).append("\n");
        return sb.toString();
    }


    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
        public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("MIMI")).append("\r\n");
        sb.append(refactorHelloService.hello("MIMI",20)).append("\r\n");
        sb.append(refactorHelloService.hello( new User("MIMI",20))).append("\r\n");
        return sb.toString();
    }
}
