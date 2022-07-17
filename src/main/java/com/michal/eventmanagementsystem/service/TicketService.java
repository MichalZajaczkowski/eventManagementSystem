package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.model.Ticket;
import com.michal.eventmanagementsystem.repository.EventRepository;
import com.michal.eventmanagementsystem.repository.TicketRepository;
import com.michal.eventmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    TicketRepository ticketRepository;
    EventRepository eventRepository;
    UserRepository userRepository;

    public TicketService(TicketRepository ticketRepository, EventRepository eventRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public List<Ticket> getTicketList() {
        return ticketRepository.findAll();
    }

    public void save(Ticket ticket) {
        checkIfUserExists(ticket);
        checkIfEventExists(ticket);
        ticketRepository.save(ticket);
    }

    private void checkIfUserExists(Ticket ticket) {
        if (ticket.getUser() != null && ticket.getUser().getId() != null) {
            checkUserIdExists(ticket.getUser().getId());

            Long userId = ticket.getUser().getId();
            userRepository.findById(userId)
                    .ifPresent(user -> {
                        ticket.setUser(user);
                        userRepository.save(ticket.getUser());
                    });
        }
    }

    private boolean checkUserIdExists(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " does not exist"));
        return true;
    }

    private void checkIfEventExists(Ticket ticket) {
        if (ticket.getEvent() != null && ticket.getEvent().getId() != null) {
            checkEventIdExists(ticket.getEvent().getId());

            Long eventId = ticket.getEvent().getId();
            eventRepository.findById(eventId)
                    .ifPresent(event -> {
                        ticket.setEvent(event);
                        eventRepository.save(ticket.getEvent());
                    });
        }
    }

    private boolean checkEventIdExists(Long id) {
        eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event with id " + id + " does not exist"));
        return true;
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }
}