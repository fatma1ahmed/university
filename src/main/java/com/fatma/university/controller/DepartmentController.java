package com.fatma.university.controller;

import com.fatma.university.model.dto.CollegeResponse;
import com.fatma.university.model.dto.DepartmentRequest;
import com.fatma.university.model.dto.DepartmentResponse;
import com.fatma.university.service.DepartmentService;
import com.fatma.university.service.impl.DepartmentCollegeServiceImpl;
import com.fatma.university.service.impl.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/departments")

@CrossOrigin("*")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid DepartmentRequest departmentRequest) throws IOException {
        return new ResponseEntity<>(departmentService.add(departmentRequest) , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@RequestBody @Valid DepartmentRequest departmentRequest, @PathVariable long id) throws IOException {
        return new ResponseEntity<>(departmentService.update(departmentRequest, id) , HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getEntityById(@PathVariable long id) {
        return new ResponseEntity<>(departmentService.getEntityById(id) , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return  new ResponseEntity<>(departmentService.getAll()  , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return departmentService.deleteById(id);

    }

}
