package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.UserAddress;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserAddressDto {

    private Long id;
    private JsonNullable<String> country;

    private JsonNullable<String> city;

    private JsonNullable<String> streetName;

    private JsonNullable<String> streetNumber;

    private JsonNullable<String> zipCode;

    private JsonNullable<String> phone;

    private JsonNullable<String> email;

    public UserAddressDto(UserAddress userAddress) {
        this.id = userAddress.getId();
        this.country = userAddress.getCountryToDto();
        this.city = userAddress.getCityToDto();
        this.streetName = userAddress.getStreetNameToDto();
        this.streetNumber = userAddress.getStreetNumber2ToDto();
        this.zipCode = userAddress.getZipCodeToDto();
        this.phone = userAddress.getPhoneToDto();
        this.email = userAddress.getEmailToDto();
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

    public UserAddress toUserAddress() {
        return new UserAddress(
                id,
                country.orElse(null),
                city.orElse(null),
                streetName.orElse(null),
                streetNumber.orElse(null),
                zipCode.orElse(null),
                phone.orElse(null),
                email.orElse(null)
        );
    }
}

