package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.dto.CategoryDto;
import com.michal.eventmanagementsystem.mapper.CategoryMapper;
import com.michal.eventmanagementsystem.model.Category;
import com.michal.eventmanagementsystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    CategoryMapper categoryMapper;
    CategoryRepository categoryRepository;

    public CategoryService(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    public Optional<Category> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        } else {
            return categoryRepository.findById(id);
        }
    }

    public void save(Category category) {
        if (category.getId() != null) {
            Long id = category.getId();
            categoryRepository.findById(id)
                    .ifPresent(category1 -> {
                                category.setId(id);
                                categoryRepository.save(category);
                            }
                    );
        } else {
            categoryRepository.save(category);
        }
    }

    public void update(Category category) {
        if (category.getId() != null) {
            Long id = category.getId();
            categoryRepository.findById(id)
                    .ifPresent(category1 -> {
                                category.setId(id);
                                categoryRepository.save(category);
                            }
                    );
        }
    }
}
