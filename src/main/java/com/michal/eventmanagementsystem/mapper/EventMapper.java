package com.michal.eventmanagementsystem.mapper;

import com.michal.eventmanagementsystem.dto.EventDto;
import com.michal.eventmanagementsystem.model.Event;
import org.mapstruct.*;

@Mapper(uses = {JsonNullableMapper.class, PlaceMapper.class, OrganizerMapper.class,StatusMapper.class, CategoryMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface EventMapper {

    @Mapping (source = "place", target = "place")
    @Mapping (source = "organizer", target = "organizer")
    @Mapping (source = "status", target = "status")
    @Mapping (source = "category", target = "category")
    @Mapping (source = "name", target = "name" , qualifiedByName = "unwrap")
    @Mapping (source = "description", target = "description" , qualifiedByName = "unwrap")
    @Mapping (source = "eventStartDate", target = "eventStartDate" , qualifiedByName = "unwrap")
    @Mapping (source = "eventEndDate", target = "eventEndDate" , qualifiedByName = "unwrap")
    Event eventDtoToEvent(EventDto eventDto);

    @Mapping (source = "place", target = "place")
    @Mapping (source = "organizer", target = "organizer")
    @Mapping (source = "status", target = "status")
    @Mapping (source = "category", target = "category")
    @Mapping (source = "name", target = "name" , qualifiedByName = "wrap")
    @Mapping (source = "description", target = "description" , qualifiedByName = "wrap")
    @Mapping (source = "eventStartDate", target = "eventStartDate" , qualifiedByName = "wrap")
    @Mapping (source = "eventEndDate", target = "eventEndDate" , qualifiedByName = "wrap")
    EventDto eventToEventDto(Event event);

    @InheritConfiguration
    @Mapping (target = "id", ignore = true)
    void update(EventDto update, @MappingTarget Event description);
}
