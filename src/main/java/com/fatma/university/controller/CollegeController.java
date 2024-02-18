package com.fatma.university.controller;

import com.fatma.university.model.dto.CollegeRequest;
import com.fatma.university.model.dto.CollegeResponse;
import com.fatma.university.model.entity.College;
import com.fatma.university.model.entity.Department;
import com.fatma.university.service.CollegeService;
import com.fatma.university.service.DepartmentCollegeService;
import com.fatma.university.service.impl.CollegeServiceImpl;
import com.fatma.university.service.impl.DepartmentCollegeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/colleges")

@CrossOrigin("*")

public class CollegeController {
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private DepartmentCollegeService departmentCollegeService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid CollegeRequest collegeRequest) throws IOException {
        return new ResponseEntity<>(collegeService.add(collegeRequest) , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid CollegeRequest collegeRequest, @PathVariable long id) throws IOException {
        return new ResponseEntity<>(collegeService.update(collegeRequest, id) , HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntityById(@PathVariable long id) {
        return new ResponseEntity<>(collegeService.getEntityById(id)  , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return new ResponseEntity(collegeService.getAll() , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return collegeService.deleteById(id);
    }

    @GetMapping("/getAllDepartments/{collegeId}")
    public ResponseEntity<?> getDepartmentsByCollegeId(@PathVariable long collegeId) {
        return new ResponseEntity<>(departmentCollegeService.getDepartmentsByCollegeId(collegeId) , HttpStatus.OK);

    }
}
