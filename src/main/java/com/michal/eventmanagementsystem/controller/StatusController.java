package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.model.Status;
import com.michal.eventmanagementsystem.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {

    StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/all")
    public List<Status> findAll() {
        return statusService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Status> findById(@PathVariable Long id) {
        return statusService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody Status status) {
        statusService.save(status);
        return ResponseEntity.status(HttpStatus.CREATED).body("Status with id: " + status.getId() + " was created");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Status status) {
        statusService.update(status);
        return ResponseEntity.status(HttpStatus.OK).body("Status with id: " + status.getId() + " was updated");
    }
}
