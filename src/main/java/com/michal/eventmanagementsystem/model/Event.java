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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "placeid")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "organizer_id", referencedColumnName = "organizerid")
    private Organizer organizer;

    @OneToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticketid")
    private Ticket ticket;

    @OneToOne
    @JoinColumn(name = "eventAddress_id", referencedColumnName = "eventAddressId")
    private EventAddress eventAddress;
}
