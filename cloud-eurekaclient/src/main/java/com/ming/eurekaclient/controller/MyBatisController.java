package com.ming.eurekaclient.controller;

import com.alibaba.fastjson.JSON;
import com.ming.dao.CategoryMapper;
import com.ming.model.Category;
import com.ming.model.CategoryExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
//        categoryMapper.deleteByPrimaryKey(252);
//        return  "";

        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andCategoryidEqualTo(1);

        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        String s = JSON.toJSONString(categories);
        return s;
    }

}
