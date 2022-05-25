package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.model.PlaceAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceAddressRepository extends JpaRepository<PlaceAddress, Long> {


    List<PlaceAddress> findAll();

    @Override
    Optional<PlaceAddress> findById(Long aLong);

    PlaceAddress save(PlaceAddress placeAddress);

    PlaceAddress getById(Long id);

    void deleteById(Long id);

    void deleteAll();

}

