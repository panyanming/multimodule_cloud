package com.ming.eurekaclient.controller;

import com.ming.helloapi2.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by panyanming on 2019/9/6.
 */
@EnableEurekaClient
@RestController
public class HomeController {


    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String index() throws InterruptedException {
        int sleepTime = new Random().nextInt(3000);
        System.out.println("休眠"+sleepTime+"ms");
        Thread.sleep(sleepTime);

        return "hello world";
    }


    @RequestMapping(value="/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello"+name;
    }

    @RequestMapping(value="/hello2",method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name,age);
    }

    @RequestMapping(value="/hello3",method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "Hello" + user.getName()+","+user.getAge();
    }
}
