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
    private Long id;

    private String description;

    public void setDescriptionToDto(String description) {
        this.description = description;
    }

    public JsonNullable<String> getDescriptionToDto() {
        return description == null ? null : JsonNullable.of(description);
    }

}
