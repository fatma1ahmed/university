package com.fatma.university.controller;

import com.fatma.university.model.dto.CategoryRequest;
import com.fatma.university.model.dto.CategoryResponse;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Video;
import com.fatma.university.service.CategoryService;
import com.fatma.university.service.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
@Tag(name = "Category Endpoints")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid CategoryRequest categoryRequest) throws IOException {
        return new ResponseEntity<>(categoryService.add(categoryRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid CategoryRequest categoryRequest, @PathVariable long id) throws IOException {
        return new ResponseEntity<>(categoryService.update(categoryRequest, id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntityById(@PathVariable long id) {
        return new ResponseEntity<>(categoryService.getEntityById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return categoryService.deleteById(id);
    }

    @GetMapping("/getAllEvents/{categoryId}")
    public ResponseEntity<?> getAllEventsByCategoryId(long categoryId) {
        return new ResponseEntity<>(categoryService.getAllEventsByCategoryId(categoryId), HttpStatus.OK);
    }

    @GetMapping("/getAllPosts/{categoryId}")
    public ResponseEntity<?> getAllPostsByCategoryId(@PathVariable long categoryId) {
        return new ResponseEntity<>(categoryService.getAllPostsByCategoryId(categoryId), HttpStatus.OK);
    }

    @GetMapping("/getAllCategories/{categoryId}")
    public ResponseEntity<?> getAllVideosByCategoryId(@PathVariable long categoryId) {
        return new ResponseEntity<>(categoryService.getAllVideosByCategoryId(categoryId), HttpStatus.OK);
    }
}
