package com.michal.eventmanagementsystem.model;

import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "place_address_id")
    private PlaceAddress placeAddress;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity_available_places")
    private String quantityAvailablePlaces;


    public void setPlaceNameToDto(JsonNullable<String> placeName) {
        this.placeName = placeName.orElse(null);
    }

    public void setDescriptionToDto(JsonNullable<String> description) {
        this.description = description.orElse(null);
    }

    public void setQuantityAvailablePlacesToDto(JsonNullable<String> quantityAvailablePlaces) {
        this.quantityAvailablePlaces = quantityAvailablePlaces.orElse(null);
    }

    public JsonNullable<String> getPlaceNameToDto() {
        return placeName == null ? null : JsonNullable.of(placeName);
    }

    public JsonNullable<String> getDescriptionToDto() {
        return description == null ? null : JsonNullable.of(description);
    }

    public JsonNullable<String> getQuantityAvailablePlacesToDto() {
        return quantityAvailablePlaces == null ? null : JsonNullable.of(quantityAvailablePlaces);
    }

}
