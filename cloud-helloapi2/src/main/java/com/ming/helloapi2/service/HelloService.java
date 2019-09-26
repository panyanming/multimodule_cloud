package com.ming.helloapi2.service;


import com.ming.helloapi2.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by panyanming on 2019/9/11.
 */

@RequestMapping("/refactor")
public interface HelloService {

        @RequestMapping(value = "/hello4",method = RequestMethod.GET)
        String hello(@RequestParam("name") String name);


        @RequestMapping(value = "/hello5",method = RequestMethod.GET)
        User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);


        @RequestMapping(value="/hello6",method = RequestMethod.POST)
        String hello(@RequestBody User user);

}
