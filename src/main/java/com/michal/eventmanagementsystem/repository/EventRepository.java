package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.dto.EventDto;
import com.michal.eventmanagementsystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAll();

    Optional<Event> findById(Long id);

    EventDto save(EventDto eventDto);

    Event getById(Long id);

    void deleteById(Long id);

    void deleteAll();
}

