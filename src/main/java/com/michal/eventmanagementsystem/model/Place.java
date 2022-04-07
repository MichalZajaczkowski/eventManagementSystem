package com.michal.eventmanagementsystem.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id", nullable = false, unique = true)
    private Long placeId;
    private String categoryId;
    private String name;
    private String subName;
    private String description;
    private String city;
    private String street;
    private String zipCode;
    private String country;
    private String phone;
    private String email;
    private String website;
    private Set<Event> events = new HashSet<>(); // bo jedno miejsce przechowywac wiele wydarzeń

    public Place() {
    }

    public Place(String categoryId, String name, String subName, String description, String city, String street, String zipCode, String country, String phone, String email, String website) {
        this.categoryId = categoryId;
        this.name = name;
        this.subName = subName;
        this.description = description;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.website = website;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place that = (Place) o;
        return Objects.equals(placeId, that.placeId) && Objects.equals(categoryId, that.categoryId) && Objects.equals(name, that.name) && Objects.equals(subName, that.subName) && Objects.equals(description, that.description) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(zipCode, that.zipCode) && Objects.equals(country, that.country) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(website, that.website) && Objects.equals(events, that.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeId, categoryId, name, subName, description, city, street, zipCode, country, phone, email, website, events);
    }
}
