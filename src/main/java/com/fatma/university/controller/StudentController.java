package com.fatma.university.controller;


import com.fatma.university.model.dto.StudentRequest;
import com.fatma.university.model.dto.StudentResponse;
import com.fatma.university.model.dto.UpdateStudentRequest;
import com.fatma.university.model.dto.UpdateStudentResponse;
import com.fatma.university.service.StudentCollegeDepartmentService;
import com.fatma.university.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
@Tag(name = "Student Endpoints")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentCollegeDepartmentService service;

    @PostMapping
    public ResponseEntity<StudentResponse> add(@RequestBody StudentRequest studentRequest) throws IOException {
        StudentResponse response = studentService.add(studentRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@RequestBody StudentRequest studentRequest, @PathVariable long id) throws IOException {
        StudentResponse response = studentService.update(studentRequest, id);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{studentId}/{collegeId}/{departmentId}")
    public ResponseEntity<UpdateStudentResponse> UpdateStudentData(@RequestBody UpdateStudentRequest updateStudentRequest, @PathVariable long studentId, @PathVariable long collegeId, @PathVariable long departmentId){
        UpdateStudentResponse response=service.UpdateStudentData(updateStudentRequest,studentId,collegeId,departmentId);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getEntityById(@PathVariable long id) {
        StudentResponse response = studentService.getEntityById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAll() {
        List<StudentResponse> response = studentService.getAll();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return studentService.deleteById(id);
    }
}
