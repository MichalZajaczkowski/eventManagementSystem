package com.michal.eventmanagementsystem.mapper.ticketMapper;

import com.michal.eventmanagementsystem.dto.dtoFotTicket.TicketDto;
import com.michal.eventmanagementsystem.model.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public class TicketDtoMapper {

    public static List<TicketDto> getCollect(List<Ticket> ticketList) {
        return ticketList.stream()
                .map(ticket -> new TicketDto(ticket.getId(), ticket.getEvent(), ticket.getUser(), ticket.getTicketNumber()))
                .collect(Collectors.toList());
    }

    public static List<TicketDto> getBasicData(List<Ticket> ticketList) {
        return ticketList.stream()
                .map(ticket -> new TicketDto(ticket.getId(), ticket.getEvent().getId(), ticket.getUser().getId(), ticket.getTicketNumber()))
                .collect(Collectors.toList());
    }
}
