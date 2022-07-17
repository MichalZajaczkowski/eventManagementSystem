package com.michal.eventmanagementsystem.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @Column(name = "price")
    private String price;

    @Column(name = "discount")
    private String discount;

    @Column(name = "total_price")
    private String totalPrice;

    @Column(name = "paid")
    private boolean paid;

    @Column(name = "paid_at")
    private String paidAt;

    @Column(name = "tickets_available")
    private boolean ticketsAvailable;

    @Column(name = "number_tickets_available")
    private String numberTicketsAvailable;
}
