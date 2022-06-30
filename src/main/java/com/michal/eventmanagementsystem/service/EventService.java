package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.dto.EventDto;
import com.michal.eventmanagementsystem.model.Event;
import com.michal.eventmanagementsystem.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    EventRepository eventRepository;
    PlaceRepository placeRepository;
    OrganizerRepository organizerRepository;
    StatusRepository statusRepository;
    CategoryRepository categoryRepository;

    public EventService(EventRepository eventRepository, PlaceRepository placeRepository, OrganizerRepository organizerRepository, StatusRepository statusRepository, CategoryRepository categoryRepository) {
        this.eventRepository = eventRepository;
        this.placeRepository = placeRepository;
        this.organizerRepository = organizerRepository;
        this.statusRepository = statusRepository;
        this.categoryRepository = categoryRepository;
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public void save(EventDto eventDto) {
        if (eventDto.getPlace() != null && eventDto.getPlace().getId() != null) {
            Long id = eventDto.getPlace().getId();
            placeRepository.findById(id)
                    .ifPresent(place -> {
                                eventDto.setPlaceToDto(place);
                                eventRepository.save(eventDto.toEvent());
                            }
                    );
        } else if (eventDto.getOrganizer() != null && eventDto.getOrganizer().getId() != null) {
            Long id = eventDto.getOrganizer().getId();
            organizerRepository.findById(id)
                    .ifPresent(organizer -> {
                                eventDto.setOrganizerToDto(organizer);
                                eventRepository.save(eventDto.toEvent());
                            }
                    );
        } else if (eventDto.getStatus() != null && eventDto.getStatus().getId() != null) {
            Long id = eventDto.getStatus().getId();
            statusRepository.findById(id)
                    .ifPresent(status -> {
                                eventDto.setStatusToDto(status);
                                eventRepository.save(eventDto.toEvent());
                            }
                    );
        } else if (eventDto.getCategory() != null && eventDto.getCategory().getId() != null) {
            Long id = eventDto.getCategory().getId();
            categoryRepository.findById(id)
                    .ifPresent(category -> {
                                eventDto.setCategoryToDto(category);
                                eventRepository.save(eventDto.toEvent());
                            }
                    );
        } else {
            eventRepository.save(eventDto.toEvent());
        }
    }
}
