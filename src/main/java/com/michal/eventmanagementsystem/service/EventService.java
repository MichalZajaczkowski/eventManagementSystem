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

    public void save(Event event) {
        checkIfPlaceExists(event);
        checkIfCategoryExists(event);
        checkIfOrganizerExists(event);
        checkIfStatusExists(event);
        eventRepository.save(event);
    }

    private void checkIfPlaceExists(Event event)  {
        if (event.getPlace() != null && event.getPlace().getId() != null) {
            checkPlaceIdExists(event.getPlace().getId());

            Long placeId = event.getPlace().getId();
            placeRepository.findById(placeId)
                    .ifPresent(place -> {
                        event.setPlace(place);
                        placeRepository.save(event.getPlace());
                    });
        }
    }

    private boolean checkPlaceIdExists(Long id) {
        placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place with id " + id + " does not exist"));
        return true;
    }

    private void checkIfCategoryExists(Event event) {
        if (event.getCategory() != null && event.getCategory().getId() != null) {
            checkCategoryIdExists(event.getCategory().getId());
            Long categoryId = event.getCategory().getId();
            categoryRepository.findById(categoryId)
                    .ifPresent(category -> {
                        event.setCategory(category);
                        categoryRepository.save(event.getCategory());
                    });
        }
    }
    private void checkCategoryIdExists(Long id) {
        organizerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizer with id " + id + " does not exist"));
    }

    private void checkIfOrganizerExists(Event event) {
        if (event.getOrganizer() != null && event.getOrganizer().getId() != null) {
            checkOrganizerIdExists(event.getOrganizer().getId());
            Long organizerId = event.getOrganizer().getId();
            organizerRepository.findById(organizerId)
                    .ifPresent(organizer -> {
                        event.setOrganizer(organizer);
                        organizerRepository.save(event.getOrganizer());
                    });
        }
    }

    private void checkOrganizerIdExists(Long id) {
        organizerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizer with id " + id + " does not exist"));
    }

    private void checkIfStatusExists(Event event) {
        if (event.getStatus() != null && event.getStatus().getId() != null) {
            checkStatusIdExists(event.getStatus().getId());
            Long statusId = event.getStatus().getId();
            statusRepository.findById(statusId)
                    .ifPresent(status -> {
                        event.setStatus(status);
                        statusRepository.save(event.getStatus());
                    });
        }
    }

    private void checkStatusIdExists(Long id) {
        statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status with id " + id + " does not exist"));
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
