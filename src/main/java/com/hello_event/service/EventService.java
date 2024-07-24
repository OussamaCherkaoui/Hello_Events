package com.hello_event.service;

import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.exception.EventNotFoundException;
import com.hello_event.exception.UserNotFoundException;
import com.hello_event.model.Event;
import com.hello_event.model.User;
import com.hello_event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getAll() {
        List<Event> events = eventRepository.findAll();
        if (events.isEmpty()) {
            throw new DatabaseEmptyException();
        }
        return events;
    }
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Event update(Event event) {
        return eventRepository.save(event);
    }

    public Event getById(Long id) throws EventNotFoundException {
        return eventRepository.findById(id).orElseThrow(EventNotFoundException::new);
    }
    public Event delete(Long id) throws EventNotFoundException {
        var event = eventRepository.findById(id).orElseThrow(EventNotFoundException::new);
        eventRepository.delete(event);
        return event;
    }
    public List<Event> getAllByDate(LocalDate date) {
        List<Event> events = eventRepository.findAllByDate(date);
        if (events.isEmpty()) {
            throw new DatabaseEmptyException();
        }
        return events;
    }
    public List<Event> getAllByLocation(String location) {
        List<Event> events = eventRepository.findAllByLocation(location);
        if (events.isEmpty()) {
            throw new DatabaseEmptyException();
        }
        return events;
    }
    public List<Event> getAllByCategory(String category) {
        List<Event> events = eventRepository.findAllByCategory(category);
        if (events.isEmpty()) {
            throw new DatabaseEmptyException();
        }
        return events;
    }

}
