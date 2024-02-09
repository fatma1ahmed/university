package com.fatma.university.controller;

import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.dto.PostRequest;
import com.fatma.university.model.dto.PostResponse;

import com.fatma.university.model.entity.Post;
import com.fatma.university.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/addPost")
    public PostResponse add(@RequestBody @Valid PostRequest postRequest) throws IOException {
        return postService.add(postRequest);
    }
    @PutMapping("/updatePost/{id}")
    public PostResponse updateEvent(@RequestBody @Valid PostRequest postRequest, @PathVariable long id) throws IOException {
        return postService.update(postRequest,id);
    }

    @GetMapping("/getPostById/{id}")
    public Post getById(@PathVariable long id) {
        return postService.getById(id);
    }
    @GetMapping("/getAllPosts")
    public List<PostResponse> getAll() {
        return postService.getAll();
    }
    @DeleteMapping("/deletePostById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return postService.deleteById(id);
    }

}


