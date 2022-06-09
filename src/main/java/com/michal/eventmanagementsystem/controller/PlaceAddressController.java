package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.PlaceAddressDto;
import com.michal.eventmanagementsystem.dto.PlaceDto;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.service.PlaceAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/placeAddress")
public class PlaceAddressController {

    PlaceAddressService placeAddressService;

    @Autowired
    public PlaceAddressController(PlaceAddressService placeAddressService) {
        this.placeAddressService = placeAddressService;
    }

    @GetMapping("/all")
    public List<PlaceAddress> findAll() {
        return placeAddressService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PlaceAddress> findById(@PathVariable Long id) {
        return placeAddressService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        placeAddressService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        placeAddressService.deleteAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody PlaceAddress placeAddress) {
        placeAddressService.save(placeAddress);
        return ResponseEntity.status(HttpStatus.CREATED).body("PlaceAddress with id: " + placeAddress.getId() + " was created");

    }

    @PutMapping("/updatePlaceAddress")
    public ResponseEntity<String> update(@RequestBody PlaceAddress placeAddress) {
        placeAddressService.update(placeAddress);
        return ResponseEntity.status(HttpStatus.OK).body("PlaceAddress with id: " + placeAddress.getId() + " was updated");

    }

    @PatchMapping("/updatePlaceAddress")
    public ResponseEntity<String> partialUpdate(@RequestBody PlaceAddressDto placeAddressDto) {
        placeAddressService.partialUpdate(placeAddressDto);
        return ResponseEntity.status(HttpStatus.OK).body("PlaceAddress with id: " + placeAddressDto.getId() + " was updated");
    }
}
