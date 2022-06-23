package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.PlaceDto;
import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping()
    public List<Place> findAll() {
        return placeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Place> findById(@PathVariable Long id) {
        return placeService.findById(id);
    }

    //create Place and save it to database with id from placeAddress
    @PostMapping()
    public ResponseEntity<PlaceDto> save(@Valid @RequestBody Place place) {
        placeService.save(place);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<PlaceDto> update(@RequestBody PlaceDto placeDto) {
        placeService.update(placeDto);
        return new ResponseEntity<>(HttpStatus.OK); //
    }

    @PatchMapping()
    public ResponseEntity<PlaceDto> partialUpdate(@RequestBody PlaceDto placeDto) {
        placeService.partialUpdate(placeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}