package com.ming.feignconsumer;

import com.ming.helloapi2.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by panyanming on 2019/9/10.
 */

@FeignClient(value = "hello-service",fallbackFactory = HelloServiceFallBackFactory.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value="/hello1",method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value="/hello2",method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value="/hello3",method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
