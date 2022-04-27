package com.michal.eventmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "event_start_date")
    private LocalDateTime eventStartDate;;

    @Column(name = "event_end_date")
    private LocalDateTime eventEndDate;

    private User user;

    private Place place;

    private Organizer organizer;

    private Ticket ticket;

    private EventAddress eventAddress;
}
