package com.michal.eventmanagementsystem.model;

import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "place_address")
public class PlaceAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public void setCountry2(JsonNullable<String> country) {
        this.country = country.orElse(null);
    }

    public void setCity2(JsonNullable<String> city) {
        this.city = city.orElse(null);
    }

    public void setStreetName2(JsonNullable<String> streetName) {
        this.streetName = streetName.orElse(null);
    }

    public void setStreetNumber2(JsonNullable<String> streetNumber) {
        this.streetNumber = streetNumber.orElse(null);
    }

    public void setZipCode2(JsonNullable<String> zipCode) {
        this.zipCode = zipCode.orElse(null);
    }

    public void setPhone2(JsonNullable<String> phone) {
        this.phone = phone.orElse(null);
    }

    public void setEmail2(JsonNullable<String> email) {
        this.email = email.orElse(null);
    }

}
