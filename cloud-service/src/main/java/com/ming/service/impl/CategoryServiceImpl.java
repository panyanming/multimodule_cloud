package com.ming.service.impl;

import com.ming.dao.CategoryMapper;
import com.ming.model.Category;
import com.ming.service.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by panyanming on 2019/11/27.
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public int getById(int id) {
        Category category = categoryMapper.selectByPrimaryKey(1);
        return category.getCategoryid();
    }
}
