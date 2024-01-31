package com.fatma.university.controller;

import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Event;
import com.fatma.university.service.EventCategorySourceService;
import com.fatma.university.service.EventService;
import com.fatma.university.service.impl.EventServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/add-event")
    public EventResponse add(@RequestBody @Valid EventRequest eventRequest) throws IOException {
        return eventService.add(eventRequest);
    }
    @PutMapping("/update-event/{id}")
    public EventResponse updateEvent(@RequestBody @Valid EventRequest eventRequest, @PathVariable long id) throws IOException {
        return eventService.update(eventRequest,id);
    }

    @GetMapping("/getEventById/{id}")
    public Event getById(@PathVariable long id) {
        return eventService.getById(id);
    }
    @GetMapping("/getAllEvents")
    public List<EventResponse> getAll() {
       return eventService.getAll();
    }
    @DeleteMapping("/deleteEventById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
       return eventService.deleteById(id);
    }
}
