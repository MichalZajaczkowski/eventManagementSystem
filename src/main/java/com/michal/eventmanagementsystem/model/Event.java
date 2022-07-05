package com.michal.eventmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "event_start_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private String eventStartDate;

    @Column(name = "event_end_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private String eventEndDate;

    public void setNameToDto(JsonNullable<String> name) {
        this.name = name.orElse(null);
    }

    public void setDescriptionToDto(JsonNullable<String> description) {
        this.description = description.orElse(null);
    }

    public void setEventStartDateToDto(JsonNullable<String> eventStartDate) {
        this.eventStartDate = eventStartDate.orElse(null);
    }

    public void setEventEndDateToDto(JsonNullable<String> eventEndDate) {
        this.eventEndDate = eventEndDate.orElse(null);
    }

}
