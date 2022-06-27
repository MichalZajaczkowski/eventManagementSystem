package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.PlaceAddress;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PlaceAddressDto {

    private Long id;
    private JsonNullable<String> country;

    private JsonNullable<String> city;

    private JsonNullable<String> streetName;

    private JsonNullable<String> streetNumber;

    private JsonNullable<String> zipCode;

    private JsonNullable<String> phone;

    private JsonNullable<String> email;

    public PlaceAddressDto(PlaceAddress placeAddress) {
        this.id = placeAddress.getId();
        this.country = placeAddress.getCountryToDto();
        this.city = placeAddress.getCityToDto();
        this.streetName = placeAddress.getStreetNameToDto();
        this.streetNumber = placeAddress.getStreetNumber2ToDto();
        this.zipCode = placeAddress.getZipCodeToDto();
        this.phone = placeAddress.getPhoneToDto();
        this.email = placeAddress.getEmailToDto();
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

    public boolean hasEmail() {
        return email != null && email.isPresent();
    }

    public PlaceAddress toPlaceAddress() {
        PlaceAddress placeAddress = new PlaceAddress();
        placeAddress.setId(id);
        placeAddress.setCountry(country.orElse(null));
        placeAddress.setCity(city.orElse(null));
        placeAddress.setStreetName(streetName.orElse(null));
        placeAddress.setStreetNumber(streetNumber.orElse(null));
        placeAddress.setZipCode(zipCode.orElse(null));
        placeAddress.setPhone(phone.orElse(null));
        placeAddress.setEmail(email.orElse(null));
        return placeAddress;
    }
}
