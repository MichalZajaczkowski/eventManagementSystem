package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.EventDto;
import com.michal.eventmanagementsystem.model.Event;
import com.michal.eventmanagementsystem.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @GetMapping()
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable Long id) {
        Optional<Event> event = eventService.findById(id);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<EventDto> save(@Valid @RequestBody EventDto eventDto) {
        eventService.save(eventDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PutMapping()
//    public ResponseEntity<EventDto> update(@RequestBody EventDto eventDto) {
//        eventService.update(eventDto);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PatchMapping()
//    public ResponseEntity<EventDto> partialUpdate(@RequestBody EventDto eventDto) {
//        eventService.partialUpdate(eventDto);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
