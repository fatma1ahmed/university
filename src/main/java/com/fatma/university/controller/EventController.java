package com.fatma.university.controller;

import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.service.EventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
@Tag(name = "Event Endpoints")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid EventRequest eventRequest) throws IOException {
        EventResponse response = eventService.add(eventRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@RequestBody @Valid EventRequest eventRequest, @PathVariable long id) throws IOException {
        EventResponse response = eventService.update(eventRequest, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntityById(@PathVariable long id) {
        EventResponse response = eventService.getEntityById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<EventResponse> response = eventService.getAll();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return eventService.deleteById(id);
    }

    @GetMapping("/getForDeparment/{departmentId}")
    public ResponseEntity<?>getAllForDepartment(@PathVariable long departmentId){
        return new ResponseEntity<>(eventService.getAllForDepartment(departmentId) , HttpStatus.OK);
    }
}
