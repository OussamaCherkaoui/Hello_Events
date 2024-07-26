package com.hello_event.service;


import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.model.Ticket;
import com.hello_event.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public Ticket save(Ticket ticket) {
        ticket.setPurchaseDate(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getTicketsByIdUser(Long userId) {
        List<Ticket> tickets = ticketRepository.findAllByUser_IdUser(userId);
        if (tickets.isEmpty()) {
            throw new DatabaseEmptyException();
        }
        return tickets;
    }

}
