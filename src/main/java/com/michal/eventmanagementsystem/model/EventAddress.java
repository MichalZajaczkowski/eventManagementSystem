package com.michal.eventmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "event_address")
public class EventAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;


    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "country")
    private String country;

    @Column(name = "phone")
    private String phone;

    @OneToOne(mappedBy = "eventAddress")
    private Event event;
}
