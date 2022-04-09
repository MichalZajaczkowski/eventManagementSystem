package com.michal.eventmanagementsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id",  nullable = false, unique = true)
    private Long eventId;
    private Long categoryId;
    private String name;
    private String startDate;
    private String endDate;
    private String descShort;
    private String descLong;
    private Boolean isActive;
    private Place place;
    private EventURL eventUrl;
    private Organizer organizer;
    private Ticket ticket;
    private User user;

    public Event() {
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public EventURL getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(EventURL eventUrl) {
        this.eventUrl = eventUrl;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event that = (Event) o;
        return Objects.equals(eventId, that.eventId) && Objects.equals(categoryId, that.categoryId)
                && Objects.equals(name, that.name) && Objects.equals(startDate, that.startDate)
                && Objects.equals(endDate, that.endDate) && Objects.equals(descShort, that.descShort)
                && Objects.equals(descLong, that.descLong) && Objects.equals(isActive, that.isActive)
                && Objects.equals(place, that.place) && Objects.equals(eventUrl, that.eventUrl)
                && Objects.equals(organizer, that.organizer) && Objects.equals(ticket, that.ticket)
                && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, categoryId, name, startDate, endDate, descShort,
                descLong, isActive, place, eventUrl, organizer, ticket, user);
    }
}