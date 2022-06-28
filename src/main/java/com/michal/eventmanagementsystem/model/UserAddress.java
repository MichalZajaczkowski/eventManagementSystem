package com.michal.eventmanagementsystem.model;

import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "user_address")
public class UserAddress {

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

    public JsonNullable<String> getCountryToDto() {
        return country == null ? null : JsonNullable.of(country);
    }

    public JsonNullable<String> getCityToDto() {
        return city == null ? null : JsonNullable.of(city);
    }

    public JsonNullable<String> getStreetNameToDto() {
        return streetName == null ? null : JsonNullable.of(streetName);
    }

    public JsonNullable<String> getStreetNumber2ToDto() {
        return streetNumber == null ? null : JsonNullable.of(streetNumber);
    }

    public JsonNullable<String> getZipCodeToDto() {
        return zipCode == null ? null : JsonNullable.of(zipCode);
    }

    public JsonNullable<String> getPhoneToDto() {
        return phone == null ? null : JsonNullable.of(phone);
    }

    public JsonNullable<String> getEmailToDto() {
        return email == null ? null : JsonNullable.of(email);
    }

}
