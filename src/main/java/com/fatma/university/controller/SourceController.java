package com.fatma.university.controller;

import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.Article;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Source;
import com.fatma.university.model.entity.Video;
import com.fatma.university.service.SourceDepartmentService;
import com.fatma.university.service.SourceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/sources")
@CrossOrigin("*")
@Tag(name = "Source Endpoints")
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @Autowired
    private SourceDepartmentService sourceDepartmentService;

    @PostMapping
    public ResponseEntity<SourceResponse> assignSourceToDepartment(@RequestBody @Valid SourceRequest sourceRequest) throws IOException {
        SourceResponse response = sourceService.add(sourceRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SourceResponse> updateSource(@RequestBody @Valid SourceRequest sourceRequest, @PathVariable long id) throws IOException {
        SourceResponse response = sourceService.update(sourceRequest, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SourceResponse> getEntityById(@PathVariable long id) {
        SourceResponse response = sourceService.getEntityById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SourceResponse>> getAll() {
        List<SourceResponse> response = sourceService.getAll();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return sourceService.deleteById(id);
    }

    @GetMapping("/getAllSources/{departmentId}")
    public ResponseEntity<List<Source>> getSourcesByDepartmentId(@PathVariable long departmentId) {
        List<Source> response = sourceDepartmentService.getSourcesByDepartmentId(departmentId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllPosts/{sourceId}")
    public ResponseEntity<List<Post>> getAllPostsBySourceId(@PathVariable long sourceId) {
        List<Post> response = sourceService.getAllPostsBySourceId(sourceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllVideos/{sourceId}")
    public ResponseEntity<List<Video>> getAllVideosBySourceId(@PathVariable long sourceId) {
        List<Video> response = sourceService.getAllVideosBySourceId(sourceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllArticles/{sourceId}")
    public ResponseEntity<List<Article>> getAllArticleBySourceId(@PathVariable long sourceId) {
        List<Article> response = sourceService.getAllArticleBySourceId(sourceId);
        return ResponseEntity.ok(response);
    }
}
