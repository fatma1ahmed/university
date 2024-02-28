package com.fatma.university.controller;

import com.fatma.university.model.dto.ArticleRequest;
import com.fatma.university.model.dto.ArticleResponse;
import com.fatma.university.model.entity.Article;
import com.fatma.university.service.ArticleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/articles")
@CrossOrigin("*")
@Tag(name= "Article Endpoints")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ArticleRequest articleRequest) throws IOException {
        return new ResponseEntity<>(articleService.add(articleRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ArticleRequest articleRequest, @PathVariable long id) throws IOException {
        return new ResponseEntity<>(articleService.update(articleRequest, id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntityById(@PathVariable long id) {
        return new ResponseEntity<>(articleService.getEntityById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(articleService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return articleService.deleteById(id);
    }


    @GetMapping("/getForDepartment/{departmentId}")
    public ResponseEntity<?>getAllForDepartment(@PathVariable long departmentId){
        return new ResponseEntity<>(articleService.getAllForDepartment(departmentId) , HttpStatus.OK);
    }

}
