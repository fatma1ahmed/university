package com.fatma.university.controller;

import com.fatma.university.model.dto.StudentCommentPostResponse;
import com.fatma.university.model.dto.StudentLikePostResponse;
import com.fatma.university.service.StudentLikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentLikePost")
public class StudentLikePostController {
    @Autowired
    private StudentLikePostService studentLikePostService;
    @PostMapping("/{studentId}/{postId}")
    public StudentLikePostResponse putLikeToPost(@PathVariable long studentId, @PathVariable long postId) {
        return studentLikePostService.putLikeToPost(studentId,postId);
    }
}
