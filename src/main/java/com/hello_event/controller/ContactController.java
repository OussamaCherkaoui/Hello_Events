package com.hello_event.controller;

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
    @PostMapping
    public ResponseEntity<Contact> saveTicket(@RequestBody Contact contact) {
        Contact savedContact = contactService.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }
}
