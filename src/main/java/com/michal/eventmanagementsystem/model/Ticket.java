package com.michal.eventmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_number")
    private Long ticketNumber;

    @Column(name = "price")
    private BigDecimal price;

    private Event event;

    private User user;
}
