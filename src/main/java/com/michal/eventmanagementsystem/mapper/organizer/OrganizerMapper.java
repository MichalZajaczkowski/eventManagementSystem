package com.michal.eventmanagementsystem.mapper.organizer;

import com.michal.eventmanagementsystem.dto.OrganizerDto;
import com.michal.eventmanagementsystem.model.Organizer;
import org.springframework.stereotype.Component;

@Component
public class OrganizerMapper {

    public Organizer organizerDtoToOrganizer(OrganizerDto organizerDto) {
        if (organizerDto == null) {
            throw new IllegalArgumentException("Parameter cannot be null");
        }

        Organizer organizer = new Organizer();

        if (organizerDto.hasName()) {
            organizer.setName(organizerDto.getName());
        }
        if (organizerDto.hasDescription()) {
            organizer.setDescription(organizerDto.getDescription());
        }
        organizer.setId(organizerDto.getId());

        return organizer;
    }

    public OrganizerDto organizerToOrganizerDto(Organizer organizer) {
        if (organizer == null) {
            return null;
        }

        OrganizerDto organizerDto = new OrganizerDto();

        organizerDto.setName(organizer.getName());
        organizerDto.setDescription(organizer.getDescription());
        organizerDto.setId(organizer.getId());

        return organizerDto;
    }
    public void upgradeOrganizer(OrganizerDto update, Organizer organizer) {
        if (update == null) {
            return;
        }

        if (update.hasName()) {
            organizer.setName(update.getName());
        }
        if (update.hasDescription()) {
            organizer.setDescription(update.getDescription());
        }
    }
}