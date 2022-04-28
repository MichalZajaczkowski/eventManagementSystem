package com.michal.eventmanagementsystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "place-address_id")
    private PlaceAddress placeAddress;

    @Column(name = "name")
    private String name;

    @Column(name = "descriptions")
    private String description;
}
