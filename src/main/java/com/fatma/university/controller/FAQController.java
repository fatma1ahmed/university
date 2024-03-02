package com.fatma.university.controller;


import com.fatma.university.model.dto.ArticleRequest;
import com.fatma.university.model.dto.FAQRequest;
import com.fatma.university.model.entity.FAQ;
import com.fatma.university.service.FAQService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/faqs")
@CrossOrigin("*")
@Tag(name = "FAQ Endpoints")
public class FAQController {


    @Autowired
    private FAQService faqService;


    @PostMapping
    public ResponseEntity<?> add(@RequestBody FAQRequest request) throws IOException {
        return new ResponseEntity<>(faqService.add(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody FAQRequest request, @PathVariable long id) throws IOException {
        return new ResponseEntity<>(faqService.update(request, id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntityById(@PathVariable long id) {
        return new ResponseEntity<>(faqService.getEntityById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(faqService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return faqService.deleteById(id);
    }





}
