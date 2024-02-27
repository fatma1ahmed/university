package com.fatma.university.controller;


import com.fatma.university.model.dto.CommentRequest;
import com.fatma.university.service.StudentCommentArticleService;
import com.fatma.university.service.StudentCommentEventService;
import com.fatma.university.service.StudentCommentPostService;
import com.fatma.university.service.StudentCommentVideoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@CrossOrigin("*")
@Tag(name = "Comment Endpoints")
public class StudentCommentController {

    @Autowired
    private StudentCommentArticleService studentCommentArticleService;


    @Autowired
    private StudentCommentEventService studentCommentEventService;

    @Autowired
    private StudentCommentPostService studentCommentPostService;

    @Autowired
    private StudentCommentVideoService studentCommentVideoService;

    @PostMapping
    public ResponseEntity<?>putComment(@RequestBody @Valid CommentRequest commentRequest){
        return switch (commentRequest.getChannelType()) {
            case POST ->
                    new ResponseEntity<>(studentCommentPostService.putCommentToPost(commentRequest.getStudentId(), commentRequest.getChannelId(), commentRequest.getComment()), HttpStatus.OK);
            case EVENT ->
                    new ResponseEntity<>(studentCommentEventService.putCommentToEvent(commentRequest.getStudentId(), commentRequest.getChannelId(), commentRequest.getComment()), HttpStatus.OK);
            case VIDEO ->
                    new ResponseEntity<>(studentCommentVideoService.putCommentToVideo(commentRequest.getStudentId(), commentRequest.getChannelId(), commentRequest.getComment()), HttpStatus.OK);
            case ARTICLE ->
                    new ResponseEntity<>(studentCommentArticleService.putCommentToArticle(commentRequest.getStudentId(), commentRequest.getChannelId(), commentRequest.getComment()), HttpStatus.OK);
        };
    }


//    @PostMapping("/video/{studentId}/{videoId}")
//    public ResponseEntity<?> putCommentToVideo(@PathVariable long studentId, @PathVariable long videoId, @RequestParam String comment) {
//        return new ResponseEntity<>(studentCommentVideoService.putCommentToVideo(studentId, videoId, comment), HttpStatus.OK);
//
//    }
//
//    @PostMapping("/post/{studentId}/{postId}")
//    public ResponseEntity<?> putCommentToPost(@PathVariable long studentId, @PathVariable long postId, @RequestParam String comment) {
//        return new ResponseEntity<>(studentCommentPostService.putCommentToPost(studentId, postId, comment), HttpStatus.OK);
//    }
//
//    @PostMapping("/event/{studentId}/{eventId}")
//    public ResponseEntity<?> putCommentToEvent(@PathVariable long studentId, @PathVariable long eventId, @RequestParam String comment) {
//        return new ResponseEntity<>(studentCommentEventService.putCommentToEvent(studentId, eventId, comment), HttpStatus.OK);
//    }
//
//
//    @PostMapping("/article/{studentId}/{articleId}")
//    public ResponseEntity<?> putCommentToArticle(@PathVariable long studentId, @PathVariable long articleId, @RequestParam String comment) {
//        return new ResponseEntity<>(studentCommentArticleService.putCommentToArticle(studentId, articleId, comment), HttpStatus.OK);
//
//    }
}
