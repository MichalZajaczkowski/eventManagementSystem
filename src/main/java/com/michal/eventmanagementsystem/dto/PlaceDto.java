package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.PlaceAddress;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PlaceDto {

    private JsonNullable<PlaceAddress> placeAddress;
    private JsonNullable<String> placeName;
    private JsonNullable<String> description;

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
