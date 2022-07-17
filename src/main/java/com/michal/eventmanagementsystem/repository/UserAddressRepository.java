package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
    List<UserAddress> findAll();

    Optional<UserAddress> findById(Long aLong);

    UserAddress save(UserAddress userAddress);

    UserAddress getById(Long id);

    void deleteById(Long id);

    void deleteAll();
}

