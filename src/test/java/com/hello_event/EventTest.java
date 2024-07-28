package com.hello_event;

import com.hello_event.model.Event;
import com.hello_event.repository.EventRepository;
import com.hello_event.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EventTest {
    @Autowired
    private EventService eventService;

    @MockBean
    private EventRepository eventRepository;


    @BeforeEach
    void SetUp(){

    }

    @Test
    void testGetAllEvents()
    {
        Event event = new Event();
        when(eventRepository.findAll()).thenReturn(List.of(event));

        List<Event> events = eventService.getAll();

        assertNotNull(events);
        assertFalse(events.isEmpty());
    }


    @Test
    void testSearchEventByCategorie()
    {
        Event event = new Event();
        String category = "Webinar";
        when(eventRepository.findAllByCategory(category)).thenReturn(List.of(event));

        List<Event> events = eventService.getAllByCategory(category);

        assertNotNull(events);
        assertFalse(events.isEmpty());
    }
}
