package com.michal.eventmanagementsystem.mapper;

import com.michal.eventmanagementsystem.dto.UserDto;
import com.michal.eventmanagementsystem.model.User;
import org.mapstruct.*;


@Mapper(uses = {JsonNullableMapper.class, UserAddressMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface UserManager {

    @Mapping(source = "userAddress", target = "userAddress")
    @Mapping(source = "userName", target = "userName", qualifiedByName = "unwrap")
    @Mapping(source = "surname", target = "surname", qualifiedByName = "unwrap")
    @Mapping(source = "login", target = "login", qualifiedByName = "unwrap")
    @Mapping(source = "password", target = "password", qualifiedByName = "unwrap")
    @Mapping(source = "email", target = "email", qualifiedByName = "unwrap")
    User userDtoToUser(UserDto userDto);

    @Mapping(source = "userAddress", target = "userAddress")
    @Mapping(source = "userName", target = "userName", qualifiedByName = "wrap")
    @Mapping(source = "surname", target = "surname", qualifiedByName = "wrap")
    @Mapping(source = "login", target = "login", qualifiedByName = "wrap")
    @Mapping(source = "password", target = "password", qualifiedByName = "wrap")
    @Mapping(source = "email", target = "email", qualifiedByName = "wrap")
    UserDto userToUserDto(User user);

    @InheritConfiguration
    @Mapping(target = "id", ignore = true)
    void update(UserDto update, @MappingTarget User description);
}
