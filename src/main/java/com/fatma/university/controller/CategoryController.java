package com.fatma.university.controller;

import com.fatma.university.model.dto.CategoryRequest;
import com.fatma.university.model.dto.CategoryResponse;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Event;
import com.fatma.university.service.CategoryService;
import com.fatma.university.service.impl.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController

public class CategoryController {
    @Autowired
    private CategoryService categoryService;
   @PostMapping("/add-category")
    public CategoryResponse add(@RequestBody @Valid CategoryRequest categoryRequest) throws IOException {
        return categoryService.add(categoryRequest);
    }
    @PutMapping("/update-category/{id}")
    public CategoryResponse update(@RequestBody @Valid CategoryRequest categoryRequest,@PathVariable long id) throws IOException {
       return categoryService.update(categoryRequest,id);
    }
    @GetMapping("/getCategoryById/{id}")
    public Category getById(@PathVariable long id) {
       return categoryService.getById(id);
    }
    @GetMapping("/getAllCategories")
    public List<CategoryResponse> getAll() {
       return categoryService.getAll();
    }
    @DeleteMapping("/deleteCategoryById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
       return categoryService.deleteById(id);
    }
    @GetMapping("/getAllEventsByCategoryId/{categoryId}")
    public List<Event> getAllEventsByCategoryId(long categoryId){
       return categoryService.getAllEventsByCategoryId(categoryId);
    }

}
