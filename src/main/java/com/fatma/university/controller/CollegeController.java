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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private DepartmentCollegeService departmentCollegeService;
    @PostMapping("/addCollage")
    public CollegeResponse add(@RequestBody @Valid CollegeRequest collegeRequest) throws IOException {
        return collegeService.add(collegeRequest);
    }
    @PutMapping("updateCollege/{id}")
    public CollegeResponse update(@RequestBody @Valid CollegeRequest collegeRequest,@PathVariable long id) throws IOException {
        return collegeService.update(collegeRequest,id);
    }
    @GetMapping("/getCollegeById/{id}")
    public College getById(@PathVariable long id) {
        return collegeService.getById(id);
    }
    @GetMapping("/getAllColleges")
    public List<CollegeResponse> getAll() {
        return collegeService.getAll();
    }
    @DeleteMapping("/deleteCollegeById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return collegeService.deleteById(id);
    }
    @GetMapping("/getAllDepartmentsByCollegeId/{collegeId}")
    public List<Department> getDepartmentsByCollegeId(@PathVariable  long collegeId) {
        return departmentCollegeService.getDepartmentsByCollegeId(collegeId);

    }
}
