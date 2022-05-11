package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.repository.PlaceAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placeAddress")
public class PlaceAddressController {

    @Autowired
    PlaceAddressRepository placeAddressRepository;

    @GetMapping("/all")
    public List<PlaceAddress> getAll() {
        return placeAddressRepository.getAll();
    }

    /*
     * get pace address by id
     * */
    @GetMapping("/{id}")
    public PlaceAddress getById(@PathVariable("id") int id) {
        return placeAddressRepository.getById(id);
    }

    /*delete placeAddress by id*/
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") int id) {
        placeAddressRepository.deleteById(id);
    }

    /*delete all placeAddress*/
    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        placeAddressRepository.deleteAll();
    }

    /*add new placeAddress*/

    @PostMapping("/add")
    public int add(@RequestBody List<PlaceAddress> placeAddressList) {
        return placeAddressRepository.add(placeAddressList);
    }

    /*put placeAddress*/
    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody PlaceAddress updatePlaceAddress) {
        PlaceAddress placeAddress = placeAddressRepository.getById(id);

        if (placeAddress != null) {
            placeAddress.setCountry(updatePlaceAddress.getCountry());
            placeAddress.setCity(updatePlaceAddress.getCity());
            placeAddress.setStreetName(updatePlaceAddress.getStreetName());
            placeAddress.setZipCode(updatePlaceAddress.getZipCode());
            placeAddress.setPhone(updatePlaceAddress.getPhone());

            placeAddressRepository.update(placeAddress);
            return 1;
        } else {
            return 0;
        }
    }

    /*patch placeAddress*/
    @PatchMapping("/{id}")
    public int patch(@PathVariable("id") int id, @RequestBody PlaceAddress updatePlaceAddress) {
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

            placeAddressRepository.update(placeAddress);
            return 1;
        }else {
            return 0;
        }
    }
}
