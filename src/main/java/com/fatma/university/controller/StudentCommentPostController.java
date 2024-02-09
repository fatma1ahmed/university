package com.fatma.university.controller;

import com.fatma.university.model.dto.StudentCommentPostResponse;
import com.fatma.university.model.entity.StudentComment;
import com.fatma.university.service.StudentCommentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/studentCommentPost")
public class StudentCommentPostController {
    @Autowired
    private StudentCommentPostService studentCommentPostService;
    @PostMapping("/putCommentToPost/{studentId}/{postId}")
    public StudentCommentPostResponse putCommentToPost(@PathVariable long studentId, @PathVariable long postId,@RequestParam String comment) {
        return studentCommentPostService.putCommentToPost(studentId, postId, comment);
    }
}
