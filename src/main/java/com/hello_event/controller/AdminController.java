package com.hello_event.controller;

import com.hello_event.enums.Role;
import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.exception.UserNotFoundException;
import com.hello_event.model.Event;
import com.hello_event.service.ContactService;
import com.hello_event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdminController {

    private final EventService eventService;
    private final ContactService contactService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        try {
            var events = eventService.getAll();
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

    @PostMapping("/add")
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
    @GetMapping("/get-all-contact")
    public ResponseEntity<?> getAllContact() {
        try {
            var contacts = contactService.getAll();
            return ResponseEntity.ok(contacts);
        } catch (DatabaseEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
