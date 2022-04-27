package com.michal.eventmanagementsystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "descriptions")
    private String description;

    private Set<Event> events;

    private PlaceAddress placeAddress;
}
