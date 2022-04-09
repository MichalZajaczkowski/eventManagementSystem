package com.michal.eventmanagementsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class EventURL {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_url_id", nullable = false, unique = true)
    private Long eventUrlId;
    private String www;
    private String tickets;
    @OneToOne(mappedBy = "eventUrl")
    private Event event;

    public EventURL() {
    }

    public EventURL(String www, String tickets, Event event) {
        this.www = www;
        this.tickets = tickets;
        this.event = event;
    }

    public Long getEventUrlId() {
        return eventUrlId;
    }

    public void setEventUrlId(Long eventUrlId) {
        this.eventUrlId = eventUrlId;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventURL that = (EventURL) o;
        return Objects.equals(eventUrlId, that.eventUrlId) && Objects.equals(www, that.www) && Objects.equals(tickets, that.tickets) && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventUrlId, www, tickets, event);
    }
}
