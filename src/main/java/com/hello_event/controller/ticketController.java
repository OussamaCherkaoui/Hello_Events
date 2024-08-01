package com.hello_event.controller;

import com.hello_event.dto.TicketDTO;
import com.hello_event.exception.UserNotFoundException;
import com.hello_event.model.Ticket;
import com.hello_event.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/ticket")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ticketController {
    private final TicketService ticketService;
    @PostMapping
    public ResponseEntity<TicketDTO> saveTicket(@RequestBody TicketDTO ticketDTO) {
        TicketDTO savedTicket = ticketService.save(ticketDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
    }

    @GetMapping("/getAllByIdUser/{id}")
    public ResponseEntity<?> getAllTicketsById(@PathVariable Long id) {
        try {
            List<Ticket> tickets = ticketService.getTicketsByIdUser(id);
            return ResponseEntity.ok(tickets);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
