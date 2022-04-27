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

    @OneToMany(mappedBy = "place")
    private Set<Event> events;

    @OneToOne
    @JoinColumn(name = "place_address_id", referencedColumnName = "placeAddressId")
    private PlaceAddress placeAddress;
}
