package com.ming.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by panyanming on 2019/9/10.
 */

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;



    @HystrixCommand(fallbackMethod="helloFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }


    public String helloFallback() {
        return "fallback";
    }
}
