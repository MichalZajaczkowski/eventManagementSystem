package com.michal.eventmanagementsystem.controller;


import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;
    /*add new place*/
    @PostMapping("/add")
    public int add(@RequestBody List<Place> placeList) {
        return placeRepository.saveAll(placeList);
    }

    @PostMapping("/add1")
    public int add1(@RequestBody List<Place> placeList) {
        return placeRepository.saveAll1(placeList);
    }
}
