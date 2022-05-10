package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.repository.PlaceAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceAddressController {

    @Autowired
    PlaceAddressRepository placeAddressRepository;

    @GetMapping("/test")
    public int test() {
        return 0;
    }

    @GetMapping("/placeAddress")
    public List<PlaceAddress> getAll() {
        return placeAddressRepository.getAll();
    }

    /*
    * get pace address by id
    * */
    @GetMapping("/placeAddress/{id}")
    public PlaceAddress getById(@PathVariable("id") int id) {
        return placeAddressRepository.getPlaceAddressById(id);
    }

    /*delete placeAddress by id*/
    @DeleteMapping("/placeAddress/delete/{id}")
    public void deleteById(@PathVariable("id") int id) {
         placeAddressRepository.deleteById(id);
    }
}
