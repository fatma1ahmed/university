package com.fatma.university.controller;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.model.dto.StudentRequest;
import com.fatma.university.model.dto.StudentResponse;
import com.fatma.university.model.entity.Student;
import com.fatma.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentResponse add(@RequestBody StudentRequest studentRequest) throws IOException {
        return studentService.add(studentRequest);
    }

    @PutMapping("/{id}")
    public StudentResponse update(@RequestBody StudentRequest studentRequest, @PathVariable long id) throws IOException {
        return studentService.update(studentRequest, id);
    }

    @GetMapping("/{id}")
    public StudentResponse getEntityById(@PathVariable long id) {
        return studentService.getEntityById(id);
    }

    @GetMapping
    public List<StudentResponse> getAll() {
        return studentService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return studentService.deleteById(id);
    }
}
