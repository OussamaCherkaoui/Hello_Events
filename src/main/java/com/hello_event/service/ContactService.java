package com.hello_event.service;

import com.hello_event.model.Contact;
import com.hello_event.model.Ticket;
import com.hello_event.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
}
