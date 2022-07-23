package com.michal.eventmanagementsystem.model;

import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
Zweryfikuj, co zawiera dana adnotacja w Lomboku bo np @Data zawiera w sobie @Getter @Setter
tu masz dokumentacj https://projectlombok.org/features/all, tyczy sie wszyskich Encji, modeli
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;

    private String description;
}
