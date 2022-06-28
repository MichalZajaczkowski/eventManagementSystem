package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.dto.PlaceAddressDto;
import com.michal.eventmanagementsystem.mapper.PlaceAddressMapper;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.repository.PlaceAddressRepository;
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

    public void save(PlaceAddressDto placeAddressDto) {
        if (placeAddressDto.getId() != null) {
            Long id = placeAddressDto.getId();
            placeAddressRepository.findById(id)
                    .ifPresent(placeAddress -> {
                                placeAddressDto.setId(placeAddress.getId());
                                placeAddressRepository.save(placeAddressDto.toPlaceAddress());
                            }
                    );
        } else {
            placeAddressRepository.save(placeAddressDto.toPlaceAddress());
        }
    }

    public void update(PlaceAddressDto placeAddressDto) {
        if (placeAddressDto.getId() != null) {
            Long id = placeAddressDto.getId();
            placeAddressRepository.findById(id)
                    .ifPresent(placeAddress1 -> {
                                placeAddressDto.setId(id);
                                placeAddressRepository.save(placeAddressDto.toPlaceAddress());
                            }
                    );
        }
    }

    public void partialUpdate(PlaceAddressDto placeAddressDto) {
        PlaceAddress placeAddress = placeAddressRepository.findById(placeAddressDto.getId()).orElse(null);
        if (placeAddress != null) {
            if (placeAddressDto.getCountry() != null) {
                placeAddress.setCountry(placeAddressDto.getCountry().orElse(placeAddress.getCountry()));
            }
            if (placeAddressDto.getCity() != null) {
                placeAddress.setCity(placeAddressDto.getCity().orElse(placeAddress.getCity()));
            }
            if (placeAddressDto.getStreetName() != null) {
                placeAddress.setStreetName(placeAddressDto.getStreetName().orElse(placeAddress.getStreetName()));
            }
            if (placeAddressDto.getStreetNumber() != null) {
                placeAddress.setStreetNumber(placeAddressDto.getStreetNumber().orElse(placeAddress.getStreetNumber()));
            }
            if (placeAddressDto.getZipCode() != null) {
                placeAddress.setZipCode(placeAddressDto.getZipCode().orElse(placeAddress.getZipCode()));
            }
            if (placeAddressDto.getPhone() != null) {
                placeAddress.setPhone(placeAddressDto.getPhone().orElse(placeAddress.getPhone()));
            }
            if (placeAddressDto.getEmail() != null) {
                placeAddress.setEmail(placeAddressDto.getEmail().orElse(placeAddress.getEmail()));
            }
            placeAddressRepository.save(placeAddress);
        }
    }
}