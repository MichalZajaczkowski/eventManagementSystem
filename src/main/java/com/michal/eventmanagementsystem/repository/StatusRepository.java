package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    List<Status> findAll();

    Optional<Status> findById(Long id);

    Status save(Status status);

    Status getById(Long id);

    void deleteById(Long id);

    void deleteAll();
}
