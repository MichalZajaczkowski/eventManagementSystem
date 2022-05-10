package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.model.PlaceAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PlaceAddressRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<PlaceAddress> getAll() {
        return jdbcTemplate.query("SELECT * FROM place_address",
                BeanPropertyRowMapper.newInstance(PlaceAddress.class));
    }

    public PlaceAddress getPlaceAddressById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM place_address WHERE id = ?",
                BeanPropertyRowMapper.newInstance(PlaceAddress.class), id);
    }

    /*delete placeAddress by id*/
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM place_address WHERE id = ?", id);
    }
}
