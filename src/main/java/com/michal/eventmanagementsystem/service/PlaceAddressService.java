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
        if (placeAddress.getId() != null) {
            Long id = placeAddress.getId();
            placeAddressRepository.findById(id)
                    .ifPresent(placeAddress1 -> {
                                placeAddress.setId(placeAddress1.getId());
                                placeAddressRepository.save(placeAddress);
                            }
                    );
        } else {
            placeAddressRepository.save(placeAddress);
        }
    }

    public void update(PlaceAddress placeAddress) {
        PlaceAddress updatePlaceAddress = placeAddressRepository.getById(placeAddress.getId());
        if (updatePlaceAddress != null) {
            updatePlaceAddress.setCountry(placeAddress.getCountry());
            updatePlaceAddress.setCity(placeAddress.getCity());
            updatePlaceAddress.setStreetName(placeAddress.getStreetName());
            updatePlaceAddress.setStreetNumber(placeAddress.getStreetNumber());
            updatePlaceAddress.setZipCode(placeAddress.getZipCode());
            updatePlaceAddress.setPhone(placeAddress.getPhone());
            updatePlaceAddress.setEmail(placeAddress.getEmail());

            placeAddressRepository.save(updatePlaceAddress);
        }
    }

    public void partialUpdate(PlaceAddressDto placeAddressDto) {
        PlaceAddress placeAddress = placeAddressRepository.findById(placeAddressDto.getId()).orElse(null);
        if (placeAddress != null) {
            if (placeAddressDto.getCountry() != null) {
                placeAddress.setCountry2(placeAddressDto.getCountry());
            }
            if (placeAddressDto.getCity() != null) {
                placeAddress.setCity2(placeAddressDto.getCity());
            }
            if (placeAddressDto.getStreetName() != null) {
                placeAddress.setStreetName2(placeAddressDto.getStreetName());
            }
            if (placeAddressDto.getStreetNumber() != null) {
                placeAddress.setStreetNumber2(placeAddressDto.getStreetNumber());
            }
            if (placeAddressDto.getZipCode() != null) {
                placeAddress.setZipCode2(placeAddressDto.getZipCode());
            }
            if (placeAddressDto.getPhone() != null) {
                placeAddress.setPhone2(placeAddressDto.getPhone());
            }
            if (placeAddressDto.getEmail() != null) {
                placeAddress.setEmail2(placeAddressDto.getEmail());
            }
            placeAddressRepository.save(placeAddress);
        }
    }
}