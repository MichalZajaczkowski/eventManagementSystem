package com.michal.eventmanagementsystem.mapper;

import com.michal.eventmanagementsystem.dto.PlaceDto;
import com.michal.eventmanagementsystem.model.Place;
import org.mapstruct.*;

@Mapper(uses = JsonNullableMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface PlaceMapper {

    @Mapping(source = "placeAddress", target = "placeAddress", qualifiedByName = "unwrap")
    @Mapping(source = "placeName", target = "placeName", qualifiedByName = "unwrap")
    @Mapping(source = "description", target = "description", qualifiedByName = "unwrap")
    Place PlaceDtoToPlace(PlaceDto placeDto);

    @Mapping(source = "placeAddress", target = "placeAddress", qualifiedByName = "wrap")
    @Mapping(source = "placeName", target = "placeName", qualifiedByName = "wrap")
    @Mapping(source = "description", target = "description", qualifiedByName = "wrap")
    PlaceDto placeToPlaceDto(Place place);

    @InheritConfiguration
    @Mapping(target = "id", ignore = true)
    void update(PlaceDto update, @MappingTarget Place description);
}
