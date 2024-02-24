package com.fatma.university.controller;

import com.fatma.university.service.StudentLikeArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentLikeArticle")
@CrossOrigin("*")
public class StudentLikeArticleController {
    @Autowired
    private StudentLikeArticleService studentLikeArticleService;
    @PostMapping("/{studentId}/{articleId}")
    public ResponseEntity<?> putLikeToArticle(@PathVariable long studentId, @PathVariable long articleId) {
        return  new ResponseEntity<>(studentLikeArticleService.putLikeToArticle(studentId,articleId)  , HttpStatus.OK);
    }
}
