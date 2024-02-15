package com.fatma.university.controller;

import com.fatma.university.model.dto.StudentCommentEventResponse;
import com.fatma.university.model.dto.StudentCommentPostResponse;
import com.fatma.university.service.StudentCommentEventService;
import com.fatma.university.service.StudentCommentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentCommentEvent")
@CrossOrigin("*")
public class StudentCommentEventController {
    @Autowired
    private StudentCommentEventService studentCommentEventService;


    @PostMapping("/{studentId}/{eventId}")

    public StudentCommentEventResponse putCommentToEvent(@PathVariable long studentId, @PathVariable long eventId, @RequestParam String comment) {
        return studentCommentEventService.putCommentToEvent(studentId, eventId, comment);
    }

}
