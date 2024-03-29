package com.fatma.university.controller;

import com.fatma.university.model.dto.PostRequest;
import com.fatma.university.model.dto.PostResponse;
import com.fatma.university.service.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
@Tag(name = "Post Endpoints")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid PostRequest postRequest) throws IOException {
        PostResponse response = postService.add(postRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@RequestBody @Valid PostRequest postRequest, @PathVariable long id) throws IOException {
        PostResponse response = postService.update(postRequest, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntityById(@PathVariable long id) {
        PostResponse response = postService.getEntityById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<PostResponse> response = postService.getAll();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return postService.deleteById(id);
    }

    @GetMapping("/getForDepartment/{departmentId}")
    public ResponseEntity<?>getAllForDepartment(@PathVariable long departmentId){
        return new ResponseEntity<>(postService.getAllForDepartment(departmentId) , HttpStatus.OK);
    }
}
