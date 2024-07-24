package com.hello_event.repository;

import com.hello_event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByDate(LocalDate date);
    List<Event> findAllByLocation(String location);
    List<Event> findAllByCategory(String category);
}
