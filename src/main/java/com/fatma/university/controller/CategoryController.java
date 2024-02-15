package com.fatma.university.controller;

import com.fatma.university.model.dto.CategoryRequest;
import com.fatma.university.model.dto.CategoryResponse;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Video;
import com.fatma.university.service.CategoryService;
import com.fatma.university.service.impl.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/categories")

@CrossOrigin("*")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryResponse add(@RequestBody @Valid CategoryRequest categoryRequest) throws IOException {
        return categoryService.add(categoryRequest);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(@RequestBody @Valid CategoryRequest categoryRequest, @PathVariable long id) throws IOException {
        return categoryService.update(categoryRequest, id);
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable long id) {
        return categoryService.getById(id);
    }

    @GetMapping
    public List<CategoryResponse> getAll() {
        return categoryService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return categoryService.deleteById(id);
    }

    @GetMapping("/getAllEvents/{categoryId}")
    public List<Event> getAllEventsByCategoryId(long categoryId) {
        return categoryService.getAllEventsByCategoryId(categoryId);
    }

    @GetMapping("/getAllPosts/{categoryId}")
    public List<Post> getAllPostsByCategoryId(@PathVariable long categoryId) {
        return categoryService.getAllPostsByCategoryId(categoryId);
    }

    @GetMapping("/getAllCategories/{categoryId}")
    public List<Video> getAllVideosByCategoryId(@PathVariable long categoryId) {
        return categoryService.getAllVideosByCategoryId(categoryId);
    }
}
