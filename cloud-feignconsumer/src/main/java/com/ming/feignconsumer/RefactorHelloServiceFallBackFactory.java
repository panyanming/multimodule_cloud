package com.ming.feignconsumer;

import com.ming.helloapi2.dto.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by panyanming on 2019/9/18.
 */
@Component
public class RefactorHelloServiceFallBackFactory implements FallbackFactory<RefactorHelloService> {

    public RefactorHelloService create(Throwable throwable) {
        return new RefactorHelloService() {
            public String hello(@RequestParam("name") String s) {
                return "r1";
            }

            public User hello(@RequestHeader("name") String s, @RequestHeader("age") Integer integer) {
                return new User("r1",0);
            }

            public String hello(@RequestBody User user) {
                return "r1";
            }
        };
    }
}
