package com.fatma.university.controller;

import com.fatma.university.model.dto.StudentCommentPostResponse;
import com.fatma.university.model.dto.StudentLikePostResponse;
import com.fatma.university.service.StudentLikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentLikePost")
@CrossOrigin("*")
public class StudentLikePostController {
    @Autowired
    private StudentLikePostService studentLikePostService;
    @PostMapping("/putLikeToPost/{studentId}/{postId}")
    public ResponseEntity<?> putLikeToPost(@PathVariable long studentId, @PathVariable long postId) {
        return new ResponseEntity<>(studentLikePostService.putLikeToPost(studentId,postId) , HttpStatus.OK);
    }
}
