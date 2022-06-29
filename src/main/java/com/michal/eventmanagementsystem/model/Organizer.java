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

    public JsonNullable<String> getNameToDto() {
        return name == null ? null : JsonNullable.of(name);
    }

    public JsonNullable<String> getDescriptionToDto() {
        return description == null ? null : JsonNullable.of(description);
    }

    public void setNameToDto(JsonNullable<String> name) {
        this.name = name.orElse(null);
    }

    public void setDescriptionToDto(JsonNullable<String> description) {
        this.description = description.orElse(null);
    }


}
