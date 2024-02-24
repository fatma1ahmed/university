package com.fatma.university.controller;

import com.fatma.university.service.StudentLikeVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentLikeVideo")
@CrossOrigin("*")
public class StudentLikeVideoController {
    @Autowired
    private StudentLikeVideoService studentLikeVideoService;
    @PostMapping("/putLikeToPost/{studentId}/{videoId}")
    public ResponseEntity<?> putLikeToVideo(@PathVariable long studentId, @PathVariable long videoId) {
        return new ResponseEntity<>(studentLikeVideoService.putLikeToVideo(studentId, videoId), HttpStatus.OK);
    }
}
