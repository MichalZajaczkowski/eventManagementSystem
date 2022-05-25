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
/*        if (place.getPlaceAddress().getId() == null || place.getId() == null ||
                place.getPlaceAddress().getId() == 0 || place.getId() == 0 ||
                !placeService.findById(place.getPlaceAddress().getId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Place was not created");
        } else {
            placeService.save(place);
            return ResponseEntity.status(HttpStatus.CREATED).body("Place with id: " + place.getId() + " was created");
        }*/
    }

    // update place name and place description, take placeAddress id, when palce id is not found return invalid query
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Place placeChange) {
        placeService.save(placeChange);
        return ResponseEntity.status(HttpStatus.OK).body("Place with id: " + placeChange.getId() + " was updated");
/*        Place place = placeService.getById(id);
        if (place == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Place with id: " + id + " was not found");
        } else {
            place.setPlaceName(placeChange.getPlaceName());
            place.setDescription(placeChange.getDescription());
            placeService.save(place);
            return ResponseEntity.status(HttpStatus.OK).body("Place with id: " + place.getId() + " was updated");
        }*/
    }


    @PatchMapping("/update")
    public ResponseEntity updatePlaceElement(@RequestBody Place updatePlace) {
        Place place = placeService.getById(updatePlace.getId());
        if (place == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Place with id: " + updatePlace.getId() + " was not found");
        } else {
            if (updatePlace.getPlaceName() != null) {
                place.setPlaceName(updatePlace.getPlaceName());
            }
            if (updatePlace.getDescription() != null) {
                place.setDescription(updatePlace.getDescription());
            }
            if (updatePlace.getPlaceAddress() != null) {
                place.setPlaceAddress(updatePlace.getPlaceAddress());
            }
            placeService.save(place);
            return ResponseEntity.status(HttpStatus.OK).body("Place with id: " + place.getId() + " was updated");
        }
    }
}
