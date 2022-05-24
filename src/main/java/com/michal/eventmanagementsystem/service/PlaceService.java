package com.michal.eventmanagementsystem.service;


import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public ResponseEntity createPlace(Place place) {
        URI location = URI.create(String.format("/places/%s", place.getPlaceName()));
        return ResponseEntity.created(location).body(placeRepository.save(place));
    }

    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    public Optional<Place> findById(Long id) {
        return placeRepository.findById(id);
    }

    public void deleteById(Long id) {
        placeRepository.deleteById(id);
    }

    public void deleteAll() {
        placeRepository.deleteAll();
    }


    public Place getById(Long id) {
        return placeRepository.getById(id);
    }

    public ResponseEntity save(Place place) {
        return ResponseEntity.ok(placeRepository.save(place));
    }

    public Object save1(Place place) {
        return placeRepository.save(place);
    }
}
