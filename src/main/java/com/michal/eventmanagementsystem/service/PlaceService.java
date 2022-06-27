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

    public void save(PlaceDto placeDto) {
        if (placeDto.getPlaceAddress() != null && placeDto.getPlaceAddress().getId() != null) {
            Long id = placeDto.getPlaceAddress().getId();
            placeAddressRepository.findById(id)
                    .ifPresent(placeAddress -> {
                                placeDto.setPlaceAddressToDto(placeAddress);
                                placeRepository.save(placeDto.toPlace());
                            }
                    );
        } else {
            placeRepository.save(placeDto.toPlace());
        }
    }


    public void update(PlaceDto placeDto) {
        if (placeDto.getPlaceAddress() == null && placeDto.getPlaceAddress().getId() == null) {
            Long id = placeDto.getPlaceAddress().getId();
            placeAddressRepository.findById(id)
                    .ifPresent(placeAddress -> {
                                placeDto.getPlaceAddress().setId(id);
                                placeRepository.save(placeDto.toPlace());
                            }
                    );
        } else {
            placeRepository.save(placeDto.toPlace());
        }
    }


    public void partialUpdate(PlaceDto placeDto) {
        Place place = placeRepository.findById(placeDto.getId()).orElse(null);
        if (place != null) {
            if (placeDto.getPlaceName() != null) {
                place.setPlaceNameToDto(placeDto.getPlaceName());
            }
            if (placeDto.getDescription() != null) {
                place.setDescriptionToDto(placeDto.getDescription());
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
//
//    private boolean isExistingId(Long id) {
//        List<PlaceAddressDto> placeAddressesDto = new ArrayList<>();
//        // Iterates all the users
//        for (PlaceAddressDto placeAddress: placeAddressesDto) {
//            // Checks if the user email is equal to the email parameter
//            if (placeAddress.getId().equals(id)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
