package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.PlaceDto;
import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    //create Place and save it to database with id from placeAddress
    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody Place place) {
        placeService.save(place);
        return ResponseEntity.status(HttpStatus.CREATED).body("Place with id: " + place.getId() + " was created");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Place place) {
        placeService.update(place);
        return ResponseEntity.status(HttpStatus.OK).body("Place with id: " + place.getId() + " was updated");
    }

    @PatchMapping("/update")
    public ResponseEntity<String> partialUpdate(@RequestBody PlaceDto placeDto) {
        placeService.partialUpdate(placeDto);
        return ResponseEntity.status(HttpStatus.OK).body("Place with id: " + placeDto.getId() + " was updated");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        placeService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        placeService.deleteAll();
    }

}
