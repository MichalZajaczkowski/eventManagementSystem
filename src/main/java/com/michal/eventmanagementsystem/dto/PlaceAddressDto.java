package com.michal.eventmanagementsystem.dto;

import lombok.Data;
import lombok.Getter;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Getter
public class PlaceAddressDto {

    private JsonNullable<String> country;
    private JsonNullable<String> city;
    private JsonNullable<String> streetName;
    private JsonNullable<String> streetNumber;
    private JsonNullable<String> zipCode;
    private JsonNullable<String> phone;

    public PlaceAddressDto(JsonNullable<String> country, JsonNullable<String> city, JsonNullable<String> streetName, JsonNullable<String> streetNumber, JsonNullable<String> zipCode, JsonNullable<String> phone) {
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public boolean hasCountry() {
        return country != null && country.isPresent();
    }

    public boolean hasCity() {
        return city != null && city.isPresent();
    }

    public boolean hasStreetName() {
        return streetName != null && streetName.isPresent();
    }

    public boolean hasStreetNumber() {
        return streetNumber != null && streetNumber.isPresent();
    }

    public boolean hasZipCode() {
        return zipCode != null && zipCode.isPresent();
    }

    public boolean hasPhone() {
        return phone != null && phone.isPresent();
    }
}
