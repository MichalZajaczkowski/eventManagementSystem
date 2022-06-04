package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.PlaceAddress;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Objects;

@Data
@Getter
public class PlaceDto {

    private JsonNullable<PlaceAddress> placeAddress;
    private JsonNullable<String> placeName;
    private JsonNullable<String> description;

    public PlaceDto(JsonNullable<PlaceAddress> placeAddress, JsonNullable<String> placeName, JsonNullable<String> description) {
        this.placeAddress = placeAddress;
        this.placeName = placeName;
        this.description = description;
    }


    public boolean hasPlaceAddress() {
       return placeAddress != null && placeAddress.isPresent();
    }

    public boolean hasPlaceName() {
       return placeName != null && placeName.isPresent();
    }

    public boolean hasDescription() {
       return description != null && description.isPresent();
    }
}
