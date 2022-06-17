package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.CategoryDto;
import com.michal.eventmanagementsystem.model.Category;
import com.michal.eventmanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody Category category) {
        categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category with id: " + category.getId() + " was created");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Category category) {
        categoryService.update(category);
        return ResponseEntity.status(HttpStatus.OK).body("Category with id: " + category.getId() + " was updated");
    }
}
