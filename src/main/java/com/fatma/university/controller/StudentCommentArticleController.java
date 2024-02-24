package com.fatma.university.controller;

import com.fatma.university.model.dto.StudentCommentArticleResponse;
import com.fatma.university.service.StudentCommentArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentCommentArticle")
@CrossOrigin("*")
public class StudentCommentArticleController {
    @Autowired
    private StudentCommentArticleService commentArticleService;
    @PostMapping("/{studentId}/{articleId}")
    public ResponseEntity<?> putCommentToEvent(@PathVariable long studentId, @PathVariable long articleId, @RequestParam String comment){
        return new ResponseEntity<>(commentArticleService.putCommentToEvent(studentId, articleId, comment) , HttpStatus.OK);

    }
}
