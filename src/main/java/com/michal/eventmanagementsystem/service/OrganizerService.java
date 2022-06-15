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

    public void save(Organizer organizer) {
        if (organizer.getId() != null) {
            Long id = organizer.getId();
            organizerRegistration.findById(id)
                    .ifPresent(organizer1 -> {
                                organizer.setId(id);
                                organizerRegistration.save(organizer);
                            }
                    );
        } else {
            organizerRegistration.save(organizer);
        }
    }

    public void update(Organizer organizer) {
        if (organizer.getId() != null) {
            Long id = organizer.getId();
            organizerRegistration.findById(id)
                    .ifPresent(organizer1 -> {
                                organizer.setId(id);
                                organizerRegistration.save(organizer);
                            }
                    );
        }
    }

    public void partialUpdate(OrganizerDto organizerDto) {
        Organizer organizer = organizerRegistration.findById(organizerDto.getId()).orElse(new Organizer());
        if (organizerDto.getName() != null) {
            organizer.setName2(organizerDto.getName());
        }
        if (organizerDto.getDescription() != null) {
            organizer.setDescription2(organizerDto.getDescription());
        }
        organizerRegistration.save(organizer);
    }
}
