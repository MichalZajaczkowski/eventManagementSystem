package com.michal.eventmanagementsystem.model;

import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "status")
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    public void setDescriptionToDto(JsonNullable<String> description) {
        this.description = description.orElse(null);
    }

    public JsonNullable<String> getDescriptionToDto() {
        return description == null ? null : JsonNullable.of(description);
    }

}
