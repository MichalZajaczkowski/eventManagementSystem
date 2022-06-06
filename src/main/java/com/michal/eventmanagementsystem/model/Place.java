package com.michal.eventmanagementsystem.model;

import lombok.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_address_id")
    private PlaceAddress placeAddress;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "description")
    private String description;
}
