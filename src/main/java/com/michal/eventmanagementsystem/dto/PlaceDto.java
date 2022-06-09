package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PlaceDto {
    private Long id;
    private PlaceAddressDto placeAddress;

    @NotNull(message = "Place name cannot be null")
    @Size(min = 1, message = "Enter a place name")
    private JsonNullable<String> placeName;

    @NotNull(message = "Description cannot be null")
    @Size(min = 1, message = "Enter a description")
    private JsonNullable<String> description;

/*    public boolean hasPlaceAddress() {
       return placeAddressDto != null && placeAddressDto.isPresent();
    }*/

    public boolean hasPlaceName() {
        return placeName != null && placeName.isPresent();
    }

    public boolean hasDescription() {
        return description != null && description.isPresent();
    }
}
