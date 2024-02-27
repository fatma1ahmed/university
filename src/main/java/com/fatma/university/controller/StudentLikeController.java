package com.fatma.university.controller;


import com.fatma.university.model.dto.CommentRequest;
import com.fatma.university.model.dto.LikeRequest;
import com.fatma.university.service.StudentLikeArticleService;
import com.fatma.university.service.StudentLikeEventService;
import com.fatma.university.service.StudentLikePostService;
import com.fatma.university.service.StudentLikeVideoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(name = "Like Endpoints")
public class StudentLikeController {


    private final StudentLikeArticleService studentLikeArticleService;
    private final StudentLikeEventService studentLikeEventService;
    private final StudentLikePostService studentLikePostService;
    private final StudentLikeVideoService studentLikeVideoService;

    @PostMapping
    public ResponseEntity<?> putLike(@RequestBody @Valid LikeRequest likeRequest) {
        return switch (likeRequest.getChannelType()) {
            case POST ->
                    new ResponseEntity<>(studentLikePostService.putLikeToPost(likeRequest.getStudentId(), likeRequest.getChannelId()), HttpStatus.OK);
            case EVENT ->
                    new ResponseEntity<>(studentLikeEventService.putLikeToEvent(likeRequest.getStudentId(), likeRequest.getChannelId()), HttpStatus.OK);
            case VIDEO ->
                    new ResponseEntity<>(studentLikeVideoService.putLikeToVideo(likeRequest.getStudentId(), likeRequest.getChannelId()), HttpStatus.OK);
            case ARTICLE ->
                    new ResponseEntity<>(studentLikeArticleService.putLikeToArticle(likeRequest.getStudentId(), likeRequest.getChannelId()), HttpStatus.OK);
        };
    }
}
