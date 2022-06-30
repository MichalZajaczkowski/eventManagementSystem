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

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.description = category.getDescriptionToDto();
    }

    public boolean hasDescription() {
        return description != null && description.isPresent();
    }

    public Category toCategory() {
        Category category = new Category();
        category.setId(id);
        category.setDescription(description == null ? null : description.orElse(null));
        return category;
    }
}
