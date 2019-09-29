package com.ming.trace1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by panyanming on 2019/9/28.
 */
@RestController
public class TraceController {

    private static final Logger logger = LoggerFactory.getLogger(TraceController.class);

    @Resource
    @LoadBalanced
    RestTemplate restTemplate;

    @RequestMapping(value = "/trace1")
    @ResponseBody
    public String trace() {
        logger.info("==== call trace1====");
        return restTemplate.getForEntity("http://trace-2/trace-2",String.class).getBody();
    }


}
