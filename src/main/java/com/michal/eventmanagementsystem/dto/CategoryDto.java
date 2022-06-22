package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.Category;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CategoryDto {

    private Long id;
    private JsonNullable<String> description;

    public boolean hasDescription() {
        return description != null && description.isPresent();
    }

    public Category toCategory() {
        Category category = new Category();
        category.setId(id);
        category.setDescription(description.orElse(null));
        return category;
    }
}
