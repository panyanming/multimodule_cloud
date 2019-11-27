package com.ming.service.service;

import com.ming.model.Category;

/**
 * Created by panyanming on 2019/11/27.
 */
public interface ICategoryService {
    int getById(int id);

    int insert(Category category);
}
