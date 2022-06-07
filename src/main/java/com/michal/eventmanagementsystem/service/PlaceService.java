package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.dto.PlaceDto;
import com.michal.eventmanagementsystem.mapper.PlaceMapper;
import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import com.michal.eventmanagementsystem.repository.PlaceAddressRepository;
import com.michal.eventmanagementsystem.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    PlaceMapper mapper;
    PlaceRepository placeRepository;
    PlaceAddressRepository placeAddressRepository;


    public PlaceService(PlaceMapper mapper, PlaceRepository placeRepository, PlaceAddressRepository placeAddressRepository) {
        this.mapper = mapper;
        this.placeRepository = placeRepository;
        this.placeAddressRepository = placeAddressRepository;
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


    public void partialUpdate(PlaceDto placeDto) {
        Place place = placeRepository.findById(placeDto.getId()).orElse(null);
        if (place != null) {
            if (placeDto.getPlaceName() != null) {
                place.setPlaceName2(placeDto.getPlaceName());
            }
            if (placeDto.getDescription() != null) {
                place.setDescription2(placeDto.getDescription());
            }
            if (placeDto.getPlaceAddress() != null) {
                PlaceAddress placeAddress = placeAddressRepository.findById(placeDto.getPlaceAddress().getId()).orElse(null);
                if (placeAddress != null) {
                    place.setPlaceAddress(placeAddress);
                }
            }
            placeRepository.save(place);
        }

    }
}
