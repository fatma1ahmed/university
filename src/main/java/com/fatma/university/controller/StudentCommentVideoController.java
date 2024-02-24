package com.fatma.university.controller;

import com.fatma.university.service.StudentCommentVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentCommentVideo")
@CrossOrigin("*")
public class StudentCommentVideoController {
    @Autowired
    private StudentCommentVideoService studentCommentVideoService;
    @PostMapping("/{studentId}/{videoId}")
    public ResponseEntity<?> putCommentToVideo(@PathVariable long studentId, @PathVariable long videoId, @RequestParam String comment){
        return new ResponseEntity<>(studentCommentVideoService.putCommentToVideo(studentId, videoId, comment) , HttpStatus.OK);

    }
}
