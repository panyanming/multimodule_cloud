package com.ming.eurekaclient.controller;


import com.ming.eurekaclient.PrintService;
import com.ming.eurekaclient.serivce.IWrite;
import com.ming.helloapi2.dto.User;
import com.ming.spi.LimitPurcharseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RefactorHelloController implements com.ming.helloapi2.service.HelloService {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    IWrite consoleWrite;

    @Resource(name = "logWrite")
    IWrite logWrite;

    @Autowired
    IWrite writeSame;

    @Autowired
    IWrite writeSame1;

    public String hello(@RequestParam("name") String name) {

        PrintService printService = PrintService.getInstance();
        printService.print();

        logWrite.write();
        consoleWrite.write();

        writeSame.write();
        writeSame1.write();

        ServiceInstance instance = discoveryClient.getInstances("hello-service").get(0);
//        int sleepTime = new Random().nextInt(3000);
//        try {
//            Thread.sleep(sleepTime);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(""+instance.getHost()+" "+instance.getPort()+" 被访问");
        return "Hello"+name;
    }

    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {

        LimitPurcharseService service = LimitPurcharseService.getInstance();
        boolean checkLimit = service.checkLimit(1, 2);
        System.out.println("checkLimit:"+checkLimit);

        return new User(name,age);
    }

    public String hello(@RequestBody User user) {
        return "Hello" + user.getName()+","+user.getAge();
    }
}
