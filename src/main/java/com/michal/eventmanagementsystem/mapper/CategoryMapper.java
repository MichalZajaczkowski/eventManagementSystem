package com.michal.eventmanagementsystem.mapper;

import com.michal.eventmanagementsystem.dto.CategoryDto;
import com.michal.eventmanagementsystem.model.Category;
import org.springframework.stereotype.Component;


@Component
public class CategoryMapper {

    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        if (categoryDto == null) {
           throw new IllegalArgumentException("Parameter cannot be null");
        }

        Category category = new Category();

        if (categoryDto.hasDescription()) {
            category.setDescription(categoryDto.getDescription());
        }
        category.setId(categoryDto.getId());

        return category;
    }

    public CategoryDto categoryToCategoryDto(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Parameter cannot be null");
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setDescription(category.getDescription());
        categoryDto.setId(category.getId());

        return categoryDto;
    }

    public void update(CategoryDto update, Category category) {
        if (update == null) {
            throw new IllegalArgumentException("Parameter cannot be null");
        }

        if (update.hasDescription()) {
            category.setDescription(update.getDescription());
        }
    }
}
