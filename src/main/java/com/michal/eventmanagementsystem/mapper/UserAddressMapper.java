package com.michal.eventmanagementsystem.mapper;

import com.michal.eventmanagementsystem.dto.UserAddressDto;
import com.michal.eventmanagementsystem.model.UserAddress;
import org.mapstruct.*;

@Mapper(uses = JsonNullableMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface UserAddressMapper {

    @Mapping(source = "country", target = "country", qualifiedByName = "unwrap")
    @Mapping(source = "city", target = "city", qualifiedByName = "unwrap")
    @Mapping(source = "streetName", target = "streetName", qualifiedByName = "unwrap")
    @Mapping(source = "streetNumber", target = "streetNumber", qualifiedByName = "unwrap")
    @Mapping(source = "zipCode", target = "zipCode", qualifiedByName = "unwrap")
    @Mapping(source = "phone", target = "phone", qualifiedByName = "unwrap")
    @Mapping(source = "email", target = "email", qualifiedByName = "unwrap")
    UserAddress userAddressDtoToUserAddress(UserAddressDto userAddressDto);

    @Mapping(source = "country", target = "country", qualifiedByName = "wrap")
    @Mapping(source = "city", target = "city", qualifiedByName = "wrap")
    @Mapping(source = "streetName", target = "streetName", qualifiedByName = "wrap")
    @Mapping(source = "streetNumber", target = "streetNumber", qualifiedByName = "wrap")
    @Mapping(source = "zipCode", target = "zipCode", qualifiedByName = "wrap")
    @Mapping(source = "phone", target = "phone", qualifiedByName = "wrap")
    @Mapping(source = "email", target = "email", qualifiedByName = "wrap")
    UserAddressDto userAddressToUserAddressDto(UserAddress userAddress);

    @InheritConfiguration
    @Mapping(target = "id", ignore = true)
    void updateUserAddress(UserAddressDto update, @MappingTarget UserAddress description);
}

