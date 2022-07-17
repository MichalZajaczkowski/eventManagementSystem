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

    private JsonNullable<String> quantityAvailablePlaces;

/*    public boolean hasPlaceAddress() {
       return placeAddressDto != null && placeAddressDto.isPresent();
    }*/

    public PlaceDto(Place place) {
        this.id = place.getId();
        this.placeAddress = new PlaceAddressDto(place.getPlaceAddress());
        this.placeName = place.getPlaceNameToDto();
        this.description = place.getDescriptionToDto();
        this.quantityAvailablePlaces = place.getQuantityAvailablePlacesToDto();
    }

    public boolean hasPlaceName() {
        return placeName != null && placeName.isPresent();
    }

    public boolean hasDescription() {
        return description != null && description.isPresent();
    }

    public boolean hasQuantityAvailablePlaces() {
        return quantityAvailablePlaces != null && quantityAvailablePlaces.isPresent();
    }

    public Place toPlace() {
        Place place = new Place();
        place.setId(id);
        place.setPlaceName(placeName.orElse(null));
        place.setDescription(description.orElse(null));
        place.setQuantityAvailablePlaces(quantityAvailablePlaces.orElse(null));
        if (placeAddress != null) {
            place.setPlaceAddress(placeAddress.toPlaceAddress());
        }
        return place;
    }

    public void setPlaceAddressToDto(PlaceAddress placeAddress) {
        this.placeAddress = new PlaceAddressDto(placeAddress);
    }
}
