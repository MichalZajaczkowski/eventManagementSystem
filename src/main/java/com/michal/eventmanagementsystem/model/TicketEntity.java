package com.michal.eventmanagementsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ticket")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;
    private String ticketType;
    private String ticketPrice;
    private String startTicket;
    private String endTicket;
    private String ticketStatus;
    private String ticketQuantity;
    private Event event;

    public TicketEntity(Long ticketId, String ticketType, String ticketPrice,
                        String startTicket, String endTicket, String ticketStatus, String ticketQuantity, Event event) {
        this.ticketId = ticketId;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
        this.startTicket = startTicket;
        this.endTicket = endTicket;
        this.ticketStatus = ticketStatus;
        this.ticketQuantity = ticketQuantity;
        this.event = event;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getStartTicket() {
        return startTicket;
    }

    public void setStartTicket(String startTicket) {
        this.startTicket = startTicket;
    }

    public String getEndTicket() {
        return endTicket;
    }

    public void setEndTicket(String endTicket) {
        this.endTicket = endTicket;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getTicketQuantity() {
        return ticketQuantity;
    }

    public void setTicketQuantity(String ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
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
        TicketEntity that = (TicketEntity) o;
        return Objects.equals(ticketId, that.ticketId) && Objects.equals(ticketType, that.ticketType) && Objects.equals(ticketPrice, that.ticketPrice) && Objects.equals(startTicket, that.startTicket) && Objects.equals(endTicket, that.endTicket) && Objects.equals(ticketStatus, that.ticketStatus) && Objects.equals(ticketQuantity, that.ticketQuantity) && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, ticketType, ticketPrice, startTicket, endTicket, ticketStatus, ticketQuantity, event);
    }
}
