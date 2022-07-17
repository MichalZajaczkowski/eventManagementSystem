package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.dtoFotTicket.TicketDto;
import com.michal.eventmanagementsystem.model.Ticket;
import com.michal.eventmanagementsystem.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.michal.eventmanagementsystem.mapper.ticketMapper.TicketDtoMapper.getBasicData;
import static com.michal.eventmanagementsystem.mapper.ticketMapper.TicketDtoMapper.getCollect;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;


    @GetMapping()
    public List<Ticket> findAll() {
        return ticketService.getTicketList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/basicCollect")
    public List<TicketDto> basicCollect() {
        return getCollect(ticketService.getTicketList());
    }
    @GetMapping("/basicData")
    public List<TicketDto> basicData() {

        return getBasicData(ticketService.getTicketList());
    }

    @PostMapping()
    public ResponseEntity<Ticket> save(@Valid @RequestBody Ticket ticket) {
        ticketService.save(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
