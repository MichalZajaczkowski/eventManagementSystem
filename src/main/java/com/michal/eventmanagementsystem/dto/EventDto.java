package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.*;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EventDto {

    public Long id;

    private PlaceDto place;

    private OrganizerDto organizer;

    private StatusDto status;

    private CategoryDto category;

    private JsonNullable<String> name;

    private JsonNullable<String> description;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw") and change String to LocalDateTime somehow it must be overcome
    private JsonNullable<String> eventStartDate;
    //same as above
    private JsonNullable<String> eventEndDate;


    public boolean hasName() {
        return name != null && name.isPresent();
    }

    public boolean hasDescription() {
        return description != null && description.isPresent();
    }

    public boolean hasEventStartDate() {
        return eventStartDate != null && eventStartDate.isPresent();
    }

    public boolean hasEventEndDate() {
        return eventEndDate != null && eventEndDate.isPresent();
    }

    public Event toEvent() {
        Event event = new Event();
        event.setName(name.orElse(null));
        event.setDescription(description.orElse(null));
        event.setEventStartDate(eventStartDate.orElse(null));
        event.setEventEndDate(eventEndDate.orElse(null));
        event.setId(id);
        if (place != null) {
            event.setPlace(place.toPlace());
        }
        if (organizer != null) {
            event.setOrganizer(organizer.toOrganizer());
        }
        if (status != null) {
            event.setStatus(status.toStatus());
        }
        if (category != null) {
            event.setCategory(category.toCategory());
        }

        return event;
    }

    public void setPlaceToDto(Place place) {
        this.place = new PlaceDto(place);
    }

    public void setOrganizerToDto(Organizer organizer) {
        this.organizer = new OrganizerDto(organizer);
    }

    public void setStatusToDto(Status status) {
        this.status = new StatusDto(status);
    }

    public void setCategoryToDto(Category category) {
        this.category = new CategoryDto(category);
    }
}
