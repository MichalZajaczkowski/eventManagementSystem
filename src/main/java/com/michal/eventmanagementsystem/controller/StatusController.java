package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.StatusDto;
import com.michal.eventmanagementsystem.model.Status;
import com.michal.eventmanagementsystem.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;

    @GetMapping()
    public List<Status> findAll() {
        return statusService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Status> findById(@PathVariable Long id) {
        return statusService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<StatusDto> save(@Valid @RequestBody StatusDto statusDto) {
        statusService.save(statusDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<StatusDto> update(@RequestBody StatusDto statusDto) {
        statusService.update(statusDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
