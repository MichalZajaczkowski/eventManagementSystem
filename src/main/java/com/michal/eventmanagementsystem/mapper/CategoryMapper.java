package com.michal.eventmanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {JsonNullableMapper.class, PlaceAddressMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface CategoryMapper {
}
