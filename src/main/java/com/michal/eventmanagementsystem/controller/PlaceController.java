package com.michal.eventmanagementsystem.controller;


import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.service.PlaceAddressService;
import com.michal.eventmanagementsystem.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place")
public class PlaceController {

    PlaceService placeService;
    PlaceAddressService placeAddressService;

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
    @PostMapping("/{id}")
    public ResponseEntity<String> save(@RequestBody Place place, @PathVariable PlaceAddress id) {
        place.setPlaceAddressId(id);
        if (placeService.findById(id.getId()).isEmpty()) {
            return new ResponseEntity<>("PlaceAddressId is null", HttpStatus.NOT_FOUND);
        }
        placeService.save(place);
        return new ResponseEntity<>("Place created", HttpStatus.CREATED);

    }

    // update place name and place description, take placeAddress id, when palce id is not found return invalid query
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Place placeChange, @PathVariable("id") Long id, PlaceAddress placeAddress) {
        Place place = placeService.getById(id);
        if (placeService.getById(id) == null || placeAddress.getId() == null) {
            return new ResponseEntity<>("Place or place Address with id " + id + " not found", HttpStatus.NOT_FOUND);
        } else {
            place.setPlaceName(placeChange.getPlaceName());
            place.setDescription(placeChange.getDescription());
            placeAddress.setId(place.getPlaceAddressId().getId());
            placeService.save(place);
            return new ResponseEntity<>("Place updated", HttpStatus.OK);

        }
    }

    /** change place address id in place*/
    @PutMapping("/changePlaceAddress/{id}")
    public ResponseEntity<String> changePlaceAddress(@RequestBody Place place, @PathVariable("id") Long id, PlaceAddress placeAddress) {
        Place place1 = placeService.getById(id);
        if (placeService.getById(id) == null || placeAddress.getId() == null) {
            return new ResponseEntity<>("Place or place Address with id " + id + " not found", HttpStatus.NOT_FOUND);
        } else {
            place1.setPlaceAddressId(place.getPlaceAddressId());
            placeService.save(place1);
            return new ResponseEntity<>("Place updated", HttpStatus.OK);

        }
    }


/*    @PatchMapping("/{id}")
    public ResponseEntity updatePlaceElement(@PathVariable("id") Long id, @RequestBody Place updatePlace) {
        Place place = placeService.getById(id);

        if(place != null){
            if(updatePlace.getPlaceName() != null){
                place.setPlaceName(updatePlace.getPlaceName());
            }
            if(updatePlace.getDescription() != null){
                place.setDescription(updatePlace.getDescription());
            }
            placeService.save(place);
            return ResponseEntity.accepted().body(place);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }*/
}
