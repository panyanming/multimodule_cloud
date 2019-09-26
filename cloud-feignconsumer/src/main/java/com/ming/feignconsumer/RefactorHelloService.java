package com.ming.feignconsumer;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by panyanming on 2019/9/11.
 */

@FeignClient(value = "HELLO-SERVICE",fallbackFactory = RefactorHelloServiceFallBackFactory.class)
public interface RefactorHelloService extends com.ming.helloapi2.service.HelloService {

}
