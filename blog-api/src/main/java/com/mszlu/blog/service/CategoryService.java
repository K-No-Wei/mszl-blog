package com.mszlu.blog.service;

import com.mszlu.blog.vo.CategoryVo;
import com.mszlu.blog.vo.Result;

public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);

    /**
     * 获取所有分类
     * @return
     */
    Result findAll();

    /**
     * 导航分类
     * @return
     */
    Result findAllDetail();

    Result categoriesDetailById(Long id);
}
