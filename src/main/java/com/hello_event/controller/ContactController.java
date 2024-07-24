package com.hello_event.controller;

import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hello_event.model.Contact;
import com.hello_event.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/contact")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        try {
            var contacts = contactService.getAll();
            return ResponseEntity.ok(contacts);
        } catch (DatabaseEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    public ResponseEntity<Contact> saveTicket(@RequestBody Contact contact) {
        Contact savedContact = contactService.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }
}
