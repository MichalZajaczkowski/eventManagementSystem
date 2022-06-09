package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.mapper.CategoryMapper;
import com.michal.eventmanagementsystem.model.Category;
import com.michal.eventmanagementsystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    CategoryMapper categoryMapper;
    CategoryRepository categoryRepository;

    public CategoryService(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }


}
