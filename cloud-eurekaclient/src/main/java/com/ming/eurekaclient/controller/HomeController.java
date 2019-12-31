package com.ming.eurekaclient.controller;

import com.ming.helloapi2.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by panyanming on 2019/9/6.
 */
@EnableEurekaClient
@RestController
public class HomeController {


    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(HttpServletRequest request) throws InterruptedException {
//        int sleepTime = new Random().nextInt(3000);
//        System.out.println("休眠"+sleepTime+"ms");
//        Thread.sleep(sleepTime);
        StringBuilder sb = new StringBuilder();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            sb.append(cookie.getName() + "=" + cookie.getValue() + ";");
        }
        Executors.newFixedThreadPool(1);
        String accessToken = request.getParameter("accessToken");
        return "hello world" + sb.toString() + "&accessToken=" + accessToken;
    }


    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello" + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "Hello" + user.getName() + "," + user.getAge();
    }

    @RequestMapping(value = "/hello4", method = RequestMethod.POST)
    public String hello(HttpServletRequest request) {
        String accessToken = request.getParameter("accessToken");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        return "hello world" + "name=" + name + "&age=" + age + "&accessToken=" + accessToken;
    }
}
