package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.PlaceAddressDto;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.service.PlaceAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/placeAddress")
public class PlaceAddressController {

    private final PlaceAddressService placeAddressService;

    @GetMapping()
    public List<PlaceAddress> findAll() {
        return placeAddressService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PlaceAddress> findById(@PathVariable Long id) {
        return placeAddressService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<PlaceAddressDto> save(@RequestBody PlaceAddressDto placeAddressDto) {
        placeAddressService.save(placeAddressDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping()
    public ResponseEntity<PlaceAddressDto> update(@RequestBody PlaceAddressDto placeAddressDto) {
        placeAddressService.update(placeAddressDto);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping()
    public ResponseEntity<PlaceAddressDto> partialUpdate(@RequestBody PlaceAddressDto placeAddressDto) {
        placeAddressService.partialUpdate(placeAddressDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
