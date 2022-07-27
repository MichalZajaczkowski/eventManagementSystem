package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.OrganizerDto;
import com.michal.eventmanagementsystem.model.Organizer;
import com.michal.eventmanagementsystem.service.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/organizer")
public class OrganizerController {

    private final OrganizerService organizerService;

    @GetMapping()
    public List<Organizer> findAll() {
        return organizerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Organizer> findById(@PathVariable Long id) {
        return organizerService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<Organizer> save(@Valid @RequestBody Organizer organizer) {
        organizerService.save(organizer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Organizer> update(@RequestBody Organizer organizer) {
        if (organizerService.findById(organizer.getId()).isPresent()) {
            organizerService.update(organizer);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
