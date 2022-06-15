package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.OrganizerDto;
import com.michal.eventmanagementsystem.model.Organizer;
import com.michal.eventmanagementsystem.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organizer")
public class OrganizerController {

    OrganizerService organizerService;

    @Autowired
    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @GetMapping("/all")
    public List<Organizer> findAll() {
        return organizerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Organizer> findById(@PathVariable Long id) {
        return organizerService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody Organizer organizer) {
        organizerService.save(organizer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Organizer with id: " + organizer.getId() + " was created");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Organizer organizer) {
        if (organizerService.findById(organizer.getId()).isPresent()) {
            organizerService.update(organizer);
            return ResponseEntity.status(HttpStatus.OK).body("Organizer with id: " + organizer.getId() + " was updated");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organizer with id: " + organizer.getId() + " was not found");
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<String> partialUpdate(@RequestBody OrganizerDto organizerDto) {
        if (organizerService.findById(organizerDto.getId()).isPresent()) {
            organizerService.partialUpdate(organizerDto);
            return ResponseEntity.status(HttpStatus.OK).body("Organizer with id: " + organizerDto.getId() + " was updated");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organizer with id: " + organizerDto.getId() + " was not found");
        }
    }
}
