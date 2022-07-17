package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAll();

    Optional<Ticket> findById(Long id);

    Ticket save(Ticket ticket);

    Ticket getById(Long id);

    void deleteById(Long id);

    void deleteAll();
}

