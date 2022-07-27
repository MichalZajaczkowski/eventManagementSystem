package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.model.Organizer;
import com.michal.eventmanagementsystem.repository.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrganizerService {

    private final OrganizerRepository organizerRepository;

    public List<Organizer> findAll() {
        return organizerRepository.findAll();
    }

    public Optional<Organizer> findById(Long id) {
        if (organizerRepository.findById(id).isPresent()) {
            return organizerRepository.findById(id);
        } else {
            throw new IllegalArgumentException("Organizer with id " + id + " does not exist");
        }
    }

    public void save(Organizer organizer) {
        if (organizerRepository.findByName(organizer.getName()).isPresent()) {
            throw new NonUniqueResultException("Organizer with name '" + organizer.getName() + "' already exists");
        } else {
            organizerRepository.save(organizer);
        }
    }

    public void update(Organizer organizer) {
        if (organizer.getId() != null) {
            Long id = organizer.getId();
            organizerRepository.findById(id)
                    .ifPresent(organizerId -> {
                                organizer.setId(id);
                                if (organizerRepository.findByName(organizer.getName()).isPresent()) {
                                    throw new NonUniqueResultException("Organizer with name '" + organizer.getName() + "' already exists");
                                } else if (organizerRepository.findByDescription(organizer.getDescription()).isPresent()) {
                                    throw new NonUniqueResultException("Organizer with description '" + organizer.getDescription() + "' already exists");
                                } else {
                                    organizerRepository.save(organizer);
                                }
                            }
                    );
        }
    }
}
