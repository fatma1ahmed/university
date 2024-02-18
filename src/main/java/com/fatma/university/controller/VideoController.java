package com.fatma.university.controller;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.model.dto.VideoRequest;
import com.fatma.university.model.dto.VideoResponse;
import com.fatma.university.model.entity.Video;
import com.fatma.university.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/videos")
@CrossOrigin("*")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping
    public ResponseEntity<VideoResponse> add(@RequestBody VideoRequest videoRequest) throws IOException {
        VideoResponse response = videoService.add(videoRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoResponse> update(@RequestBody VideoRequest videoRequest, @PathVariable long id) throws IOException {
        VideoResponse response = videoService.update(videoRequest, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoResponse> getEntityById(@PathVariable long id) {
        VideoResponse response = videoService.getEntityById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<VideoResponse>> getAll() {
        List<VideoResponse> response = videoService.getAll();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return videoService.deleteById(id);
    }
}
