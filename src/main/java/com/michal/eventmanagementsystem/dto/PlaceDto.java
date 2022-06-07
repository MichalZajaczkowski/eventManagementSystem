package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.Place;
import com.michal.eventmanagementsystem.model.PlaceAddress;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PlaceDto {
    private Long id;
    private PlaceAddressDto placeAddress;
    private JsonNullable<String> placeName;
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
