package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.Category;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CategoryDto {

    private Long id;
    private String description;

    public boolean hasDescription() {
        return description != null;
    }

    public Category toCategory() {
        Category category = new Category();
        category.setId(id);
        category.setDescription(description);
        return category;
    }
}
