package com.michal.eventmanagementsystem.model;

import lombok.Data;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "organizers")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public void setName2(JsonNullable<String> name) {
        this.name = name.orElse(null);
    }

    public void setDescription2(JsonNullable<String> description) {
        this.description = description.orElse(null);
    }
}
