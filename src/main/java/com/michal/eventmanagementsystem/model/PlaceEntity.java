package com.michal.eventmanagementsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "place")
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeId;
    private Long categoryId;
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

    public PlaceEntity() {
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceEntity placeEntity = (PlaceEntity) o;
        return Objects.equals(placeId, placeEntity.placeId) && Objects.equals(categoryId, placeEntity.categoryId) && Objects.equals(name, placeEntity.name) && Objects.equals(subName, placeEntity.subName) && Objects.equals(description, placeEntity.description) && Objects.equals(city, placeEntity.city) && Objects.equals(street, placeEntity.street) && Objects.equals(zipCode, placeEntity.zipCode) && Objects.equals(country, placeEntity.country) && Objects.equals(phone, placeEntity.phone) && Objects.equals(email, placeEntity.email) && Objects.equals(website, placeEntity.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeId, categoryId, name, subName, description, city, street, zipCode, country, phone, email, website);
    }
}
