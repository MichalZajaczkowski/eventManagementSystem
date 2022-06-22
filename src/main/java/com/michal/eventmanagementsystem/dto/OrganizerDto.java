package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.Organizer;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrganizerDto {
    private Long id;
    private JsonNullable <String> name;
    private JsonNullable <String> description;

    public boolean hasName() {
        return name != null && name.isPresent();
    }

    public boolean hasDescription() {
        return description != null && description.isPresent();
    }

    public Organizer toOrganizer() {
        Organizer organizer = new Organizer();
        organizer.setId(id);
        organizer.setName(name.orElse(null));
        organizer.setDescription(description.orElse(null));
        return organizer;
    }
}
