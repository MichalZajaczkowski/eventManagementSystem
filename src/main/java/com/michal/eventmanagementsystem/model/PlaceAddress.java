package com.michal.eventmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "place_address")
public class PlaceAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "phone")
    private String phone;
}
