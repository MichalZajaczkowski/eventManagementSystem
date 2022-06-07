package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.dto.PlaceAddressDto;
import com.michal.eventmanagementsystem.mapper.PlaceAddressMapper;
import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.repository.PlaceAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceAddressService {

    PlaceAddressMapper placeAddressMapper;
    PlaceAddressRepository placeAddressRepository;

    public PlaceAddressService(PlaceAddressMapper placeAddressMapper, PlaceAddressRepository placeAddressRepository) {
        this.placeAddressMapper = placeAddressMapper;
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

    public PlaceAddressDto updatePlaceAddress(Long id, PlaceAddressDto placeAddressUpdate) {
        PlaceAddress placeAddress = placeAddressRepository.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("PlaceAddress not found");
        });
        placeAddressMapper.updatePlaceAddress(placeAddressUpdate, placeAddress);
        placeAddressRepository.save(placeAddress);


        return placeAddressMapper.placeAddressToPlaceAddressDto(placeAddress);
    }

}

