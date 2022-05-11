package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.model.PlaceAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PlaceAddressRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<PlaceAddress> getAll() {
        return jdbcTemplate.query("SELECT * FROM place_address",
                BeanPropertyRowMapper.newInstance(PlaceAddress.class));
    }

    public PlaceAddress getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM place_address WHERE id = ?",
                BeanPropertyRowMapper.newInstance(PlaceAddress.class), id);
    }

    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM place_address WHERE id = ?", id);
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM place_address");
    }

    public int add(List<PlaceAddress> placeAddressList) {
        placeAddressList.forEach(placeAddress ->
                jdbcTemplate.update("INSERT INTO place_address (country, city, street_name, street_number, zip_code, phone) VALUES (?, ?, ?, ?, ?, ?)",
                        placeAddress.getCountry(), placeAddress.getCity(), placeAddress.getStreetName(), placeAddress.getStreetNumber(),
                        placeAddress.getZipCode(), placeAddress.getPhone()));

        return placeAddressList.size();
    }

    /*update placeAddress*/
    public int update(PlaceAddress placeAddress) {
        jdbcTemplate.update("UPDATE place_address SET country = ?, city = ?, street_name = ?, street_number = ?, zip_code = ?, phone = ? WHERE id = ?",
                placeAddress.getCountry(), placeAddress.getCity(), placeAddress.getStreetName(), placeAddress.getStreetNumber(),
                placeAddress.getZipCode(), placeAddress.getPhone(), placeAddress.getId());

        return 1;
    }
}

