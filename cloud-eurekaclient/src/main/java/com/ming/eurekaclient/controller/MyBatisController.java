package com.ming.eurekaclient.controller;

import com.ming.dao.CategoryMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by panyanming on 2019/10/30.
 */
@RequestMapping(value = "mt")
@Controller
public class MyBatisController {

    @Resource
    private CategoryMapper categoryMapper;


    @RequestMapping(value = "testMapper.do")
    @ResponseBody
    public String testMapper(HttpServletRequest request) {
        categoryMapper.deleteByPrimaryKey(252);
        return  "";
    }

}
