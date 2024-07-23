package com.hello_event.controller;


import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.model.Event;
import com.hello_event.service.EventService;
import com.hello_event.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/event")
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
}
