package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.dto.EventDto;
import com.michal.eventmanagementsystem.mapper.EventMapper;
import com.michal.eventmanagementsystem.model.*;
import com.michal.eventmanagementsystem.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    EventMapper mapper;
    EventRepository eventRepository;
    PlaceRepository placeRepository;
    OrganizerRepository organizerRepository;
    StatusRepository statusRepository;
    CategoryRepository categoryRepository;

    public EventService(EventMapper mapper, EventRepository eventRepository, PlaceRepository placeRepository, OrganizerRepository organizerRepository, StatusRepository statusRepository, CategoryRepository categoryRepository) {
        this.mapper = mapper;
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
            Long placeId = eventDto.getPlace().getId();
            Long categoryId = eventDto.getCategory().getId();
            Long organizerId = eventDto.getOrganizer().getId();
            Long statusId = eventDto.getStatus().getId();
            placeRepository.findById(placeId)
                    .ifPresent(place -> {
                        eventDto.setPlaceToDto(place);
                        categoryRepository.findById(categoryId)
                                .ifPresent(category1 -> {
                                    eventDto.setCategoryToDto(category1);
                                    organizerRepository.findById(organizerId)
                                            .ifPresent(organizer1 -> {
                                                eventDto.setOrganizerToDto(organizer1);
                                                statusRepository.findById(statusId)
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

    public void partialUpdate(EventDto eventDto) {
        Event event = eventRepository.findById(eventDto.getId()).orElse(null);
        if (event != null) {
            if (eventDto.getName() != null) {
                event.setNameToDto(eventDto.getName());
            }
            if (eventDto.getDescription() != null) {
                event.setDescriptionToDto(eventDto.getDescription());
            }
            if (eventDto.getEventStartDate() != null) {
                event.setEventStartDateToDto(eventDto.getEventStartDate());
            }
            if (eventDto.getEventEndDate() != null) {
                event.setEventEndDateToDto(eventDto.getEventEndDate());
            }
            if (eventDto.getPlace() != null || eventDto.getPlace().getId() != null) {
                Place place = placeRepository.findById(eventDto.getPlace().getId()).orElse(null);
                if (place != null) {
                    event.setPlace(place);
                }
            }
            if (eventDto.getOrganizer() != null || eventDto.getOrganizer().getId() != null) {
                Organizer organizer = organizerRepository.findById(eventDto.getOrganizer().getId()).orElse(null);
                if (organizer != null) {
                    event.setOrganizer(organizer);
                }
            }
            if (eventDto.getStatus() != null || eventDto.getStatus().getId() != null) {
                Status status = statusRepository.findById(eventDto.getStatus().getId()).orElse(null);
                if (status != null) {
                    event.setStatus(status);
                }
            }
            if (eventDto.getCategory() != null || eventDto.getCategory().getId() != null) {
                Category category = categoryRepository.findById(eventDto.getCategory().getId()).orElse(null);
                if (category != null) {
                    event.setCategory(category);
                }
            }
            eventRepository.save(event);
        }
    }
}
