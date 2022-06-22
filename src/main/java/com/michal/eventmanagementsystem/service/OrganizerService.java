package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.dto.OrganizerDto;
import com.michal.eventmanagementsystem.model.Organizer;
import com.michal.eventmanagementsystem.repository.OrganizerRegistration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {

    OrganizerRegistration organizerRegistration;

    public OrganizerService(OrganizerRegistration organizerRegistration) {
        this.organizerRegistration = organizerRegistration;
    }


    public List<Organizer> findAll() {
        return organizerRegistration.findAll();
    }

    public Optional<Organizer> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        } else {
            return organizerRegistration.findById(id);
        }
    }

    public void save(OrganizerDto organizerDto) {
        //Organizer organizer = organizerRegistration.findById(organizerDto.getId()).orElse(new Organizer());
        if (organizerDto.getId() != null) {
            Long id = organizerDto.getId();
            organizerRegistration.findById(id)
                    .ifPresent(organizer1 -> {
                                organizerDto.setId(id);
                                organizerRegistration.save(organizerDto.toOrganizer());
                            }
                    );
        } else {
            organizerRegistration.save(organizerDto.toOrganizer());
        }
    }

    public void update(OrganizerDto organizerDto) {
        if (organizerDto.getId() != null) {
            Long id = organizerDto.getId();
            organizerRegistration.findById(id)
                    .ifPresent(organizer1 -> {
                                organizerDto.setId(id);
                                organizerRegistration.save(organizerDto.toOrganizer());
                            }
                    );
        }
    }

    public void partialUpdate(OrganizerDto organizerDto) {
        Organizer organizer = organizerRegistration.findById(organizerDto.getId()).orElse(new Organizer());
        if (organizerDto.getName() != null) {
            organizer.setName(organizerDto.getName().orElse(organizer.getName()));
        }
        if (organizerDto.getDescription() != null) {
            organizer.setDescription(organizerDto.getDescription().orElse(organizer.getDescription()));
        }
        organizerRegistration.save(organizer);
    }
}
