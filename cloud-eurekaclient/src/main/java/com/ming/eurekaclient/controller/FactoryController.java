package com.ming.eurekaclient.controller;

import com.ming.eurekaclient.serivce.IFactorySerivce;
import com.ming.eurekaclient.serivce.ISortService;
import com.ming.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panyanming on 2019/10/29.
 */
@RequestMapping(value = "factory")
@Controller
public class FactoryController {

    @Autowired
    IFactorySerivce factorySerivce;

    @RequestMapping(value = "testFactory.do")
    @ResponseBody
    public void testFactoryBean(HttpServletRequest request) {
        factorySerivce.excecute(1);
    }


    @RequestMapping(value = "testModel.do")
    @ResponseBody
    public void testModel(HttpServletRequest request) {
        Book book = new Book();
        book.setName("book1");
        book.setPrice(0.01);
    }

    @Autowired
    ISortService sortService;

    @RequestMapping(value = "testSort.do")
    @ResponseBody
    public void testSort() {
        sortService.execute(3);
    }


}
