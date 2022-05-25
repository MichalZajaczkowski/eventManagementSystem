package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.repository.PlaceAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceAddressService {

    PlaceAddressRepository placeAddressRepository;

    @Autowired
    public PlaceAddressService(PlaceAddressRepository placeAddressRepository) {
        this.placeAddressRepository = placeAddressRepository;
    }

    public void save(PlaceAddress placeAddress) {
        placeAddressRepository.save(placeAddress);
    }
}
