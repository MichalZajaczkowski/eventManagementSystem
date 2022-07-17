package com.michal.eventmanagementsystem.mapper;

import com.michal.eventmanagementsystem.dto.OrganizerDto;
import com.michal.eventmanagementsystem.model.Organizer;
import org.mapstruct.*;

@Mapper(uses = JsonNullableMapper.class,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface OrganizerMapper {

    @Mapping(source = "name", target = "name", qualifiedByName = "unwrap")
    @Mapping(source = "description", target = "description", qualifiedByName = "unwrap")
    Organizer organizerDtoToOrganizer(OrganizerDto organizerDto);

    @Mapping(source = "name", target = "name", qualifiedByName = "wrap")
    @Mapping(source = "description", target = "description", qualifiedByName = "wrap")
    OrganizerDto organizerToOrganizerDto(Organizer organizer);

    @InheritConfiguration
    @Mapping(target = "id", ignore = true)
    void upgradeOrganizer(OrganizerDto update, @MappingTarget Organizer organizer);

}
