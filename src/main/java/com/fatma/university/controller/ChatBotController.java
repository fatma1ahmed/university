package com.fatma.university.controller;

import com.fatma.university.model.dto.ChatBotRequest;
import com.fatma.university.model.dto.CollegeRequest;
import com.fatma.university.model.dto.CollegeResponse;
import com.fatma.university.model.entity.Department;
import com.fatma.university.service.ChatBotService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Tag(name = "ChatBot Endpoints")
@RequestMapping("/chat")
@CrossOrigin("*")
public class ChatBotController {

    @Autowired
    private ChatBotService chatBotService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid ChatBotRequest
                                         chatBotRequest) throws IOException {
        return new ResponseEntity<>(chatBotService.add(chatBotRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid ChatBotRequest chatBotRequest, @PathVariable long id) throws IOException {
        return new ResponseEntity<>(chatBotService.update(chatBotRequest, id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntityById(@PathVariable long id) {
        return new ResponseEntity<>(chatBotService.getEntityById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(chatBotService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return chatBotService.deleteById(id);
    }

}
