package com.fatma.university.controller;

import com.fatma.university.model.dto.ArticleRequest;
import com.fatma.university.model.dto.ArticleResponse;
import com.fatma.university.model.entity.Article;
import com.fatma.university.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/articles")
@CrossOrigin("*")

public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping
    public ArticleResponse add(@RequestBody  ArticleRequest articleRequest) throws IOException {
        return articleService.add(articleRequest);
    }
    @PutMapping("/{id}")
    public ArticleResponse update(@RequestBody ArticleRequest articleRequest, @PathVariable long id) throws IOException {
        return articleService.update(articleRequest,id);
    }
    @GetMapping("/{id}")
    public Article getById(@PathVariable long id) {
        return articleService.getById(id);
    }
    @GetMapping
    public List<ArticleResponse> getAll() {
        return articleService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return articleService.deleteById(id);
    }

}
