package com.fatma.university.controller;

import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Event;
import com.fatma.university.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/events")

@CrossOrigin("*")

public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public EventResponse add(@RequestBody @Valid EventRequest eventRequest) throws IOException {
        return eventService.add(eventRequest);
    }
    @PutMapping("/{id}")
    public EventResponse updateEvent(@RequestBody @Valid EventRequest eventRequest, @PathVariable long id) throws IOException {
        return eventService.update(eventRequest,id);
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable long id) {
        return eventService.getById(id);
    }
    @GetMapping
    public List<EventResponse> getAll() {
       return eventService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
       return eventService.deleteById(id);
    }

}
