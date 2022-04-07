package com.michal.eventmanagementsystem.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "organizer")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organizer_id", nullable = false, unique = true)
    private Long organizerId;
    private String categoryId;
    private String organizerName;
    private String organizerEmail;
    private String organizerPhone;
    private String description;
    private Set<Event> events = new HashSet<>(); // bo jeden organizator może robić wiele wydarzeń

    public Organizer() {
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public String getOrganizerPhone() {
        return organizerPhone;
    }

    public void setOrganizerPhone(String organizerPhone) {
        this.organizerPhone = organizerPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizer that = (Organizer) o;
        return Objects.equals(organizerId, that.organizerId) && Objects.equals(categoryId, that.categoryId) && Objects.equals(organizerName, that.organizerName) && Objects.equals(organizerEmail, that.organizerEmail) && Objects.equals(organizerPhone, that.organizerPhone) && Objects.equals(description, that.description) && Objects.equals(events, that.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizerId, categoryId, organizerName, organizerEmail, organizerPhone, description, events);
    }
}
