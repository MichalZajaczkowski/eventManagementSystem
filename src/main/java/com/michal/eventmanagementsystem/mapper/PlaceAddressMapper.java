package com.michal.eventmanagementsystem.mapper;

import com.michal.eventmanagementsystem.dto.PlaceAddressDto;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import org.mapstruct.*;

@Mapper(uses = JsonNullableMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface PlaceAddressMapper {

    @Mapping(source = "country", target = "country", qualifiedByName = "unwrap")
    @Mapping(source = "city", target = "city", qualifiedByName = "unwrap")
    @Mapping(source = "streetName", target = "streetName", qualifiedByName = "unwrap")
    @Mapping(source = "streetNumber", target = "streetNumber", qualifiedByName = "unwrap")
    @Mapping(source = "zipCode", target = "zipCode", qualifiedByName = "unwrap")
    @Mapping(source = "phone", target = "phone", qualifiedByName = "unwrap")
    PlaceAddress placeAddressDtoToPlaceAddress(PlaceAddressDto placeAddressDto);
    @Mapping(source = "country", target = "country", qualifiedByName = "wrap")
    @Mapping(source = "city", target = "city", qualifiedByName = "wrap")
    @Mapping(source = "streetName", target = "streetName", qualifiedByName = "wrap")
    @Mapping(source = "streetNumber", target = "streetNumber", qualifiedByName = "wrap")
    @Mapping(source = "zipCode", target = "zipCode", qualifiedByName = "wrap")
    @Mapping(source = "phone", target = "phone", qualifiedByName = "wrap")
    PlaceAddressDto placeAddressToPlaceAddressDto(PlaceAddress placeAddress);

    @InheritConfiguration
    @Mapping(target = "id", ignore = true)
    void updatePlaceAddress(PlaceAddressDto update, @MappingTarget PlaceAddress description);
}
