package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.repository.PlaceAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/placeAddress")
public class PlaceAddressController {

    @Autowired
    PlaceAddressRepository placeAddressRepository;

    @GetMapping("/all")
    public List<PlaceAddress> findAll() {
        return placeAddressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PlaceAddress> findById(@PathVariable Long id) {
        return placeAddressRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        placeAddressRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        placeAddressRepository.deleteAll();
    }

    @PostMapping("/save")
    public PlaceAddress save(@RequestBody PlaceAddress placeAddressList) {
        return placeAddressRepository.save(placeAddressList);

    }

    @PutMapping("/{id}")
    public int save(@PathVariable("id") Long id, @RequestBody PlaceAddress updatePlaceAddress) {
        PlaceAddress placeAddress = placeAddressRepository.getById(id);

        if (placeAddress != null) {
            placeAddress.setCountry(updatePlaceAddress.getCountry());
            placeAddress.setCity(updatePlaceAddress.getCity());
            placeAddress.setStreetName(updatePlaceAddress.getStreetName());
            placeAddress.setZipCode(updatePlaceAddress.getZipCode());
            placeAddress.setPhone(updatePlaceAddress.getPhone());

            placeAddressRepository.save(placeAddress);
            return 1;
        } else {
            return 0;
        }
    }

    @PatchMapping("/{id}")
    public int patch(@PathVariable("id") Long id, @RequestBody PlaceAddress updatePlaceAddress) {
        PlaceAddress placeAddress = placeAddressRepository.getById(id);

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

            placeAddressRepository.save(placeAddress);
            return 1;
        }else {
            return 0;
        }
    }
}
