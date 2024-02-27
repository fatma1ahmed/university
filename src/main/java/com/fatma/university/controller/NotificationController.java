package com.fatma.university.controller;

import com.fatma.university.service.impl.NotificationServiceImp;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@Tag(name = "Notification Endpoints")
public class NotificationController {

    @Autowired
    private NotificationServiceImp notificationServiceImp;

    @GetMapping("/source/{sourceId}")
    public ResponseEntity<?> getAllNotificationsForSource(@PathVariable long sourceId){
        return ResponseEntity.ok(notificationServiceImp.getAllForSource(sourceId));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getAllNotificationsForPost(@PathVariable long postId){
        return ResponseEntity.ok(notificationServiceImp.getAllForPost(postId));
    }
    @GetMapping("/event/{eventId}")
    public ResponseEntity<?> getAllNotificationsForEvent(@PathVariable long eventId){
        return ResponseEntity.ok(notificationServiceImp.getAllForEvent(eventId));
    }
    @GetMapping("/article/{articleId}")
    public ResponseEntity<?> getAllNotificationsForArticle(@PathVariable long articleId){
        return ResponseEntity.ok(notificationServiceImp.getAllForSource(articleId));
    }
    @GetMapping("/video/{videoId}")
    public ResponseEntity<?> getAllNotificationsForVideo(@PathVariable long videoId){
        return ResponseEntity.ok(notificationServiceImp.getAllForVideo(videoId));
    }








}
