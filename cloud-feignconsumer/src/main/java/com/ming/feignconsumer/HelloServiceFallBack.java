package com.ming.feignconsumer;


import com.ming.helloapi2.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by panyanming on 2019/9/18.
 */
@Component
public class HelloServiceFallBack implements HelloService {

    public String hello() {
        return "error";
    }

    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User("未知",0);
    }

    public String hello(@RequestBody User user) {
        return "error";
    }
}
