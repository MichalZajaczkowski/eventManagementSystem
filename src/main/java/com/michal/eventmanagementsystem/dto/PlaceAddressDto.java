package com.michal.eventmanagementsystem.dto;

import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PlaceAddressDto {

    private JsonNullable<String> country;
    private JsonNullable<String> city;
    private JsonNullable<String> streetName;
    private JsonNullable<String> streetNumber;
    private JsonNullable<String> zipCode;
    private JsonNullable<String> phone;


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
