package com.hello_event.service;

import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.model.Contact;
import com.hello_event.model.User;
import com.hello_event.model.Contact;
import com.hello_event.model.Ticket;
import com.hello_event.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public List<Contact> getAll() {
        var contacts = contactRepository.findAll();
        if (contacts.isEmpty()) {
            throw new DatabaseEmptyException();
        }
        return contacts;
    }

    public Contact save(Contact contact) {
        contact.setRequestDate(LocalDateTime.now());
        return contactRepository.save(contact);
    }

}
