package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizerRegistration extends JpaRepository<Organizer, Long> {

    List<Organizer> findAll();

    Optional<Organizer> findById(Long id);

    Organizer save(Organizer organizer);

    Organizer getById(Long id);

    void deleteById(Long id);

    void deleteAll();

}

