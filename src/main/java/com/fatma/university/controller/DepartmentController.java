package com.fatma.university.controller;

import com.fatma.university.model.dto.DepartmentRequest;
import com.fatma.university.model.dto.DepartmentResponse;
import com.fatma.university.service.DepartmentService;
import com.fatma.university.service.impl.DepartmentCollegeServiceImpl;
import com.fatma.university.service.impl.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DepartmentResponse add(@RequestBody @Valid DepartmentRequest departmentRequest) throws IOException {
        return departmentService.add(departmentRequest);
    }

    @PutMapping("/{id}")
    public DepartmentResponse updateDepartment(@RequestBody @Valid DepartmentRequest departmentRequest, @PathVariable long id) throws IOException {
        return departmentService.update(departmentRequest, id);
    }

    @GetMapping
    public List<DepartmentResponse> getAll() {
        return departmentService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return departmentService.deleteById(id);

    }

}
