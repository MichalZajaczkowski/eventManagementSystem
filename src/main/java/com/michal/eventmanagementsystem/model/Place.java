package com.michal.eventmanagementsystem.model;

import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "place_address_id")
    private PlaceAddress placeAddress;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity_available_places")
    private Integer quantityAvailablePlaces;


    public void setPlaceNameToDto(JsonNullable<String> placeName) {
        this.placeName = placeName.orElse(null);
    }

    public void setDescriptionToDto(JsonNullable<String> description) {
        this.description = description.orElse(null);
    }
}
