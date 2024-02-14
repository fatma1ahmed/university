package com.fatma.university.controller;

import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.*;
import com.fatma.university.service.SourceDepartmentService;
import com.fatma.university.service.SourceService;
import com.fatma.university.service.impl.SourceServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/sources")
@CrossOrigin("*")
public class SourceController {
    @Autowired
    private SourceService sourceService;
    @Autowired
    private SourceDepartmentService sourceDepartmentService;
    @PostMapping
    public SourceResponse assignSourceToDepartment(@RequestBody @Valid SourceRequest sourceRequest) throws IOException {
        return sourceService.add(sourceRequest);
    }
    @PutMapping("/{id}")
    public SourceResponse updateSource(@RequestBody @Valid SourceRequest sourceRequest,@PathVariable long id) throws IOException {
        return sourceService.update(sourceRequest,id);
    }
    @GetMapping("/{id}")
    public Source getById(@PathVariable long id) {
        return sourceService.getById(id);
    }
    @GetMapping
    public List<SourceResponse> getAll() {
        return sourceService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return sourceService.deleteById(id);
    }

    @GetMapping("/getAllSources/{departmentId}")
    public  List<Source> getSourcesByDepartmentId(@PathVariable long departmentId){
        return sourceDepartmentService.getSourcesByDepartmentId(departmentId);
    }
    @GetMapping("/getAllPosts/{sourceId}")
    public List<Post> getAllPostsBySourceId(@PathVariable long sourceId){
        return sourceService.getAllPostsBySourceId(sourceId);
    }
    @GetMapping("/getAllVideos/{sourceId}")
    public List<Video> getAllVideosBySourceId(@PathVariable long sourceId){
        return sourceService.getAllVideosBySourceId(sourceId);
    }
    @GetMapping("/getAllArticles/{sourceId}")
    public List<Article> getAllArticleBySourceId(@PathVariable long sourceId){
        return sourceService.getAllArticleBySourceId(sourceId);
    }

}
