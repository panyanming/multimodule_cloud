package com.ming.eurekaclient.controller;

import com.ming.model.Category;
import com.ming.service.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by panyanming on 2019/10/30.
 */
@RequestMapping(value = "mt")
@Controller
public class MyBatisController {

//    @Resource
//    private CategoryMapper categoryMapper;

    @Resource
    private ICategoryService categoryService;

    @RequestMapping(value = "testMapper.do")
    @ResponseBody
    public String testMapper(HttpServletRequest request) {
//        categoryMapper.deleteByPrimaryKey(252);
//        return  "";

//        CategoryExample categoryExample = new CategoryExample();
//        CategoryExample.Criteria criteria = categoryExample.createCriteria();
//        criteria.andCategoryidEqualTo(1);
//
//        List<Category> categories = categoryMapper.selectByExample(categoryExample);
//        String s = JSON.toJSONString(categories);
//        returns;
        int byId = categoryService.getById(1);
        return byId + "";
    }


    @RequestMapping(value = "insert.do")
    @ResponseBody
    public String insert(HttpServletRequest request) {
        Category category = new Category();
        category.setCreatedate(new Date());
        category.setCreator(1);
        category.setLevel(1);
        category.setName("categoryname");
        category.setParent(1);
        category.setSequence(1);
        category.setStatus(1);
        int byId = categoryService.insert(category);
        return byId + "";
    }

}
