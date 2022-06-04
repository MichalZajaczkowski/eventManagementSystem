package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.repository.PlaceAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceAddressService {

    PlaceAddressRepository placeAddressRepository;

    @Autowired
    public PlaceAddressService(PlaceAddressRepository placeAddressRepository) {
        this.placeAddressRepository = placeAddressRepository;
    }

    public List<PlaceAddress> findAll() {
        return placeAddressRepository.findAll();
    }

    public Optional<PlaceAddress> findById(Long id) {
        return placeAddressRepository.findById(id);
    }

    public void deleteById(Long id) {
        placeAddressRepository.deleteById(id);
    }

    public void deleteAll() {
        placeAddressRepository.deleteAll();
    }

    public PlaceAddress getById(Long id) {
        return placeAddressRepository.getById(id);
    }

    public void save(PlaceAddress placeAddress) {
        placeAddressRepository.save(placeAddress);
    }
}
