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
    public VideoResponse add(@RequestBody VideoRequest videoRequest) throws IOException {
        return videoService.add(videoRequest);
    }
    @PutMapping("/{id}")
    public VideoResponse update(@RequestBody VideoRequest videoRequest, @PathVariable long id) throws IOException {
   return videoService.update(videoRequest,id);
    }
    @GetMapping("/{id}")
    public Video getById(@PathVariable long id) {
        return videoService.getById(id);
    }

  @GetMapping
    public List<VideoResponse> getAll() {
        return videoService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return videoService.deleteById(id);

    }
}
