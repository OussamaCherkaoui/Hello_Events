package com.hello_event.controller;

import com.hello_event.enums.Role;
import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.exception.UserNotFoundException;
import com.hello_event.model.Event;
import com.hello_event.model.TeamInfo;
import com.hello_event.model.Ticket;
import com.hello_event.model.User;
import com.hello_event.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdminController {

    private final EventService eventService;
    private final ContactService contactService;
    private final TeamInfoService teamInfoService;
    private final TicketService ticketService;
    private final UserService userService;

    @GetMapping("/getAllEvents")
    public ResponseEntity<?> getAll() {
        try {
            List<Event> events = eventService.getAll();
            return ResponseEntity.ok(events);
        } catch (DatabaseEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        try {
            var event = eventService.getById(Long.valueOf(id));
            return ResponseEntity.ok(event);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/addEvent")
    public ResponseEntity<Event> save(@RequestBody Event event) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(event));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Event event) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(event));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        try {
            var deletedEvent = eventService.delete(Long.valueOf(id));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(deletedEvent);
        } catch (UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/getAll-contact")
    public ResponseEntity<?> getAllContact() {
        try {
            var contacts = contactService.getAll();
            return ResponseEntity.ok(contacts);
        } catch (DatabaseEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/saveMembreOfTeam")
    public ResponseEntity<TeamInfo> saveTeam(@RequestBody TeamInfo teamInfo) {
        TeamInfo savedTeamInfo = teamInfoService.save(teamInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(teamInfo);
    }
    @GetMapping("/getAllTickets")
    public ResponseEntity<?> getAllTickets() {
        try {
            List<Ticket> tickets = ticketService.getAllTicket();
            return ResponseEntity.ok(tickets);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<User> users = userService.getAll();
            return ResponseEntity.ok(users);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
