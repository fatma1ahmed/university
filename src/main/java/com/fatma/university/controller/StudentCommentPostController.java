package com.fatma.university.controller;

import com.fatma.university.model.dto.StudentCommentPostResponse;
import com.fatma.university.model.entity.StudentComment;
import com.fatma.university.service.StudentCommentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/studentCommentPost")
@CrossOrigin("*")
public class StudentCommentPostController {
    @Autowired
    private StudentCommentPostService studentCommentPostService;
    @PostMapping("/{studentId}/{postId}")
    public ResponseEntity<?> putCommentToPost(@PathVariable long studentId, @PathVariable long postId, @RequestParam String comment) {
        return new ResponseEntity<>(studentCommentPostService.putCommentToPost(studentId, postId, comment) , HttpStatus.OK);
    }
}
