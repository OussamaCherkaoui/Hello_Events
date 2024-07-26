package com.hello_event.controller;


import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.model.Event;
import com.hello_event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasAuthority;

@RestController
@RequestMapping("/api/user/event")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class eventController {
    private final EventService eventService;


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            List<Event> events = eventService.getAll();
            return ResponseEntity.ok(events);
        } catch (DatabaseEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/searchByDate/{date}")
    public ResponseEntity<?> searchByDate(@PathVariable LocalDate date) {
        try {
            List<Event> events = eventService.getAllByDate(date);
            return ResponseEntity.ok(events);
        } catch (DatabaseEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/searchByLocation/{location}")
    public ResponseEntity<?> searchByLocation(@PathVariable String location) {
        try {
            List<Event> events = eventService.getAllByLocation(location);
            return ResponseEntity.ok(events);
        } catch (DatabaseEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/searchByCategory/{category}")
    public ResponseEntity<?> searchByCategory(@PathVariable String category) {
        try {
            List<Event> events = eventService.getAllByCategory(category);
            return ResponseEntity.ok(events);
        } catch (DatabaseEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
