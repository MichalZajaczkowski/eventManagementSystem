package com.michal.eventmanagementsystem.service;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.repository.PlaceAddressRepository;
import com.michal.eventmanagementsystem.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    PlaceRepository placeRepository;
    PlaceAddressRepository placeAddressRepository;


    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
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

    public void save(Place place) {
        if (place.getPlaceAddress() != null && place.getPlaceAddress().getId() != null) {
            Long id = place.getPlaceAddress().getId();
            placeAddressRepository.findById(id)
                    .ifPresent(placeAddress -> {
                                place.setPlaceAddress(placeAddress);
                                placeRepository.save(place);
                            }
                    );
        } else {
            placeRepository.save(place);
        }
    }

    public void update(Place place) {
        if (place.getPlaceAddress() == null && place.getPlaceAddress().getId() == null) {
            Long id = place.getPlaceAddress().getId();
            placeAddressRepository.findById(id)
                    .ifPresent(placeAddress -> {
                                place.setPlaceAddress(placeAddress);
                                placeRepository.save(place);
                            }
                    );
        } else {
            placeRepository.save(place);
        }
    }
}

