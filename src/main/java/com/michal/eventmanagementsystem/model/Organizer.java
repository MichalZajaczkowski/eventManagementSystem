package com.michal.eventmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "organizers")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "organizer")
    private Set<Event> events;

    @OneToOne
    @JoinColumn(name = "place_address_id", referencedColumnName = "placeAddressId")
    private PlaceAddress placeAddress;
}
