package com.michal.eventmanagementsystem.dto.dtoFotTicket;

import com.michal.eventmanagementsystem.model.Event;
import com.michal.eventmanagementsystem.model.User;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TicketDto {

        private Long id;
        private Event event;
        private User user;
        private String ticketNumber;
        private String price;
        private String discount;
        private String totalPrice;
        private boolean paid;
        private String paidAt;
        private boolean ticketsAvailable;
        private String numberTicketsAvailable;

    public TicketDto(Long id, Event event, User user, String ticketNumber) {
        this.id = id;
        this.event = event;
        this.user = user;
        this.ticketNumber = ticketNumber;
    }

    public TicketDto(Long id, Long eventId, Long userId, String ticketNumber) {
        this.id = id;
        this.event = new Event(eventId);
        this.user = new User(userId);
        this.ticketNumber = ticketNumber;
    }
}
