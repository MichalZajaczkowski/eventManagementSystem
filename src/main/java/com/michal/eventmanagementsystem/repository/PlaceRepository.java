package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaceRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public int saveAll(List<Place> placeList) {
        placeList.forEach(place ->
            jdbcTemplate.update("INSERT INTO place (place_address_id, place_name, description) VALUES (?, ?, ?)",
                    place.getPlaceAddressId(), place.getPlaceName(), place.getDescription()));
        return 1;
    }

    public int saveAll1(List<Place> placeList) {
        placeList.forEach(place ->
                jdbcTemplate.update("INSERT INTO place (place_name, description) VALUES (?, ?, ?)",
                        place.getPlaceName(), place.getDescription()));
        return 1;
    }

}