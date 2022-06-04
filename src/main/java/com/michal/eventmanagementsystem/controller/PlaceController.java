package com.michal.eventmanagementsystem.controller;


import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.service.PlaceAddressService;
import com.michal.eventmanagementsystem.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/place")
public class PlaceController {

    PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/all")
    public List<Place> findAll() {
        return placeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Place> findById(@PathVariable Long id) {
        return placeService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        placeService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        placeService.deleteAll();
    }

    //create Place and save it to database with id from placeAddress
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Place place) {
        placeService.save(place);
        return ResponseEntity.status(HttpStatus.CREATED).body("Place with id: " + place.getId() + " was created");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Place place) {
        placeService.update(place);
        return ResponseEntity.status(HttpStatus.OK).body("Place with id: " + place.getId() + " was updated");
    }
}
