package com.ming.trace2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panyanming on 2019/9/28.
 */
@RestController
public class TraceController {


    Logger logger = LoggerFactory.getLogger(TraceController.class);


    @RequestMapping(value = "/trace-2")
    @ResponseBody
    public String trace(HttpServletRequest request) {
        logger.info("=====<call trace2>,traceId={},spanId={}=====",
                request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
        return "trace2";
    }
}
