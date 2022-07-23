package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAll();

    Optional<Category> findById(Long aLong);

    Category save(Category category);

    Category getById(Long aLong);

    void deleteById(Long aLong);

    void deleteAll();

    Optional<Object> findByDescription(String description);
}
