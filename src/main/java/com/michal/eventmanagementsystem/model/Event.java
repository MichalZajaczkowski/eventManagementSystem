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

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place placeId;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizerId;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "event_start_date")
    private LocalDateTime eventStartDate;

    @Column(name = "event_end_date")
    private LocalDateTime eventEndDate;

}
