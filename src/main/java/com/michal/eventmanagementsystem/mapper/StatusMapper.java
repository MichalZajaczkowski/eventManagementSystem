package com.michal.eventmanagementsystem.mapper;

import com.michal.eventmanagementsystem.dto.StatusDto;
import com.michal.eventmanagementsystem.model.Status;
import org.mapstruct.*;

@Mapper(uses = JsonNullableMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface StatusMapper {

    @Mapping(source = "description", target = "description", qualifiedByName = "unwrap")
    Status statusDtoToStatus(StatusDto statusDto);

    @Mapping(source = "description", target = "description", qualifiedByName = "wrap")
    StatusDto statusToStatusDto(Status status);

    @InheritConfiguration
    @Mapping(target = "id", ignore = true)
    void update(StatusDto update, @MappingTarget Status status);

}
