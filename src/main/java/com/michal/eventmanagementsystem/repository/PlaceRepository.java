package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findAll();

    Optional<Place> findById(Long id);

    Place save(Place place);

    Place getById(Long id);

    void deleteById(Long id);

    void deleteAll();

}