package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.repository.PlaceAddressRepository;
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

    @PutMapping("/{id}")
    public int save(@PathVariable("id") Long id, @RequestBody PlaceAddress updatePlaceAddress) {
        PlaceAddress placeAddress = placeAddressService.getById(id);

        if (placeAddress != null) {
            placeAddress.setCountry(updatePlaceAddress.getCountry());
            placeAddress.setCity(updatePlaceAddress.getCity());
            placeAddress.setStreetName(updatePlaceAddress.getStreetName());
            placeAddress.setZipCode(updatePlaceAddress.getZipCode());
            placeAddress.setPhone(updatePlaceAddress.getPhone());

            placeAddressService.save(placeAddress);
            return 1;
        } else {
            return 0;
        }
    }

/*    @PatchMapping("/{id}")
    public int patch(@PathVariable("id") Long id, @RequestBody PlaceAddress updatePlaceAddress) {
        PlaceAddress placeAddress = placeAddressService.getById(id);

        if (placeAddress != null) {
            if (updatePlaceAddress.getCountry() != null) {
                placeAddress.setCountry(updatePlaceAddress.getCountry());
            }
            if (updatePlaceAddress.getCity() != null) {
                placeAddress.setCity(updatePlaceAddress.getCity());
            }
            if (updatePlaceAddress.getStreetName() != null) {
                placeAddress.setStreetNumber(updatePlaceAddress.getStreetNumber());
            }
            if (updatePlaceAddress.getStreetNumber() != null) {
                placeAddress.setStreetNumber(updatePlaceAddress.getStreetNumber());
            }
            if (updatePlaceAddress.getZipCode() != null) {
                placeAddress.setZipCode(updatePlaceAddress.getZipCode());
            }
            if (updatePlaceAddress.getPhone() != null) {
                placeAddress.setPhone(updatePlaceAddress.getPhone());
            }

            placeAddressService.save(placeAddress);
            return 1;
        }else {
            return 0;
        }
    }*/
}
