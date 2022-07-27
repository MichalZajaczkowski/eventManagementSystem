package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.Organizer;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrganizerDto {
    private Long id;
    private String name;
    private String description;


    public boolean hasName() {
        return name != null;
    }

    public boolean hasDescription() {
        return description != null;
    }

    public Organizer toOrganizer() {
        Organizer organizer = new Organizer();
        organizer.setId(id);
        organizer.setName(name);
        organizer.setDescription(description);
        return organizer;
    }
}
