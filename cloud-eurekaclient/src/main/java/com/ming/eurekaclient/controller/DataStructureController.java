package com.ming.eurekaclient.controller;

import com.ming.eurekaclient.datastructure.LRU;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by panyanming on 2019/12/12.
 */
@Controller
@RequestMapping(value = "datastructure")
public class DataStructureController {

    @RequestMapping(value = "lru.do")
    @ResponseBody
    public void lru() {
        LRU lru = new LRU();
        lru.add(1);
        lru.add(2);
        lru.add(3);
        System.out.println(lru.toString());

        lru.add(4);
        System.out.println(lru.toString());

        lru.add(2);
        System.out.println(lru.toString());
    }
}
