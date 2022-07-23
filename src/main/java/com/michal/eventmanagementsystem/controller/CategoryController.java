package com.michal.eventmanagementsystem.controller;


import com.michal.eventmanagementsystem.model.Category;
import com.michal.eventmanagementsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<Category> save(@Valid @RequestBody Category category) {
        categoryService.save(category);
          return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Category> update(@RequestBody Category category) {
        categoryService.update(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
