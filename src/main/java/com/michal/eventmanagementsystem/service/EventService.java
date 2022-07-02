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
        if ((eventDto.getPlace() != null && eventDto.getPlace().getId() != null)
                || (eventDto.getOrganizer() != null && eventDto.getOrganizer().getId() != null)
                || (eventDto.getStatus() != null && eventDto.getStatus().getId() != null)
                || (eventDto.getCategory() != null && eventDto.getCategory().getId() != null)) {
            Long id = eventDto.getPlace().getId();
            Long category = eventDto.getCategory().getId();
            Long organizer = eventDto.getOrganizer().getId();
            Long status = eventDto.getStatus().getId();
            placeRepository.findById(id)
                    .ifPresent(place -> {
                        eventDto.setPlaceToDto(place);
                        categoryRepository.findById(category)
                                .ifPresent(category1 -> {
                                    eventDto.setCategoryToDto(category1);
                                    organizerRepository.findById(organizer)
                                            .ifPresent(organizer1 -> {
                                                eventDto.setOrganizerToDto(organizer1);
                                                statusRepository.findById(status)
                                                        .ifPresent(status1 -> {
                                                            eventDto.setStatusToDto(status1);
                                                            eventRepository.save(eventDto.toEvent());
                                                        });
                                            });
                                });
                    });
        } else {
            eventRepository.save(eventDto.toEvent());
        }
    }
}
