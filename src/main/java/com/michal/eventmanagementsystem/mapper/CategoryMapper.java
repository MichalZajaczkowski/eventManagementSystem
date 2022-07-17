package com.michal.eventmanagementsystem.mapper;

import com.michal.eventmanagementsystem.dto.CategoryDto;
import com.michal.eventmanagementsystem.model.Category;
import org.mapstruct.*;

@Mapper(uses = JsonNullableMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "description", target = "description", qualifiedByName = "unwrap")
    Category categoryDtoToCategory(CategoryDto categoryDto);

    @Mapping(source = "description", target = "description", qualifiedByName = "wrap")
    CategoryDto categoryToCategoryDto(Category category);

    @InheritConfiguration
    @Mapping(target = "id", ignore = true)
    void update(CategoryDto update, @MappingTarget Category category);
}
