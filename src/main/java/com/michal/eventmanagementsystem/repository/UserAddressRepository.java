package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
    List<UserAddress> findAll();

    Optional<UserAddress> findById(Long id);

    Place save(Place place);

    UserAddress getById(Long id);

    void deleteById(Long id);

    void deleteAll();
}

