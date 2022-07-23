package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.model.Category;
import com.michal.eventmanagementsystem.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    public Optional<Category> findById(Long id) {
        if (categoryRepository.findById(id).isPresent()) {
            return categoryRepository.findById(id);
        } else {
            throw new IllegalArgumentException("Category with id " + id + " does not exist");
        }
    }

    public void save(Category category) {
        if (categoryRepository.findByDescription(category.getDescription()).isPresent()) {
            throw new NonUniqueResultException("Category with description '" + category.getDescription() + "' already exists");
        } else {
            categoryRepository.save(category);
        }
    }


    public void update(Category category) {
        if (category.getId() != null) {
            Long id = category.getId();
            categoryRepository.findById(id)
                    .ifPresent(categoryId -> {
                                category.setId(id);
                                if (categoryRepository.findByDescription(category.getDescription()).isPresent()) {
                                    throw new NonUniqueResultException("Category with description '" + category.getDescription() + "' already exists");
                                } else {
                                    categoryRepository.save(category);
                                }
                            }
                    );
        }
    }
}



