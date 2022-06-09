package com.michal.eventmanagementsystem.dto;

import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PlaceAddressDto {

    private Long id;
    @NotNull
    @Size
    private JsonNullable<String> country;

    @NotNull
    private JsonNullable<String> city;

    @NotEmpty
    private JsonNullable<String> streetName;

    @NotNull
    private JsonNullable<String> streetNumber;

    @NotNull

    @NotNull
    private JsonNullable<String> zipCode;

    @NotNull
    private JsonNullable<String> phone;

    @NotNull
    @Email
    private JsonNullable<String> email;


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
}
