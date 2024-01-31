package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.DepartmentMapper;
import com.fatma.university.model.dto.DepartmentRequest;
import com.fatma.university.model.dto.DepartmentResponse;
import com.fatma.university.model.entity.Department;
import com.fatma.university.reposity.DepartmentRepo;
import com.fatma.university.service.DepartmentCollegeService;
import com.fatma.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private DepartmentCollegeService departmentCollegeService;
    @Override
    public DepartmentResponse add(DepartmentRequest departmentRequest) {
        long collegeId=departmentRequest.getCollegeId();
        Department department =departmentMapper.toEntity(departmentRequest);
        departmentCollegeService.assignDepartmentToCollege(department,collegeId);
        DepartmentResponse departmentResponse=new DepartmentResponse();
        departmentResponse.setCollegeName(department.getCollege().getCollegeName());
        departmentResponse.setDepartmentName(department.getDepartmentName());
        departmentResponse.setDetails(department.getDetails());
         departmentRepo.save(department);
         return departmentResponse;

    }
    @Override
    public DepartmentResponse update(DepartmentRequest departmentRequest,long id){
        checkThisIsFoundORThrowException(id);
        long collegeId=departmentRequest.getCollegeId();
        Department department=departmentMapper.toEntity(departmentRequest);
        department.setId(id);
        departmentCollegeService.updateDepartment(department,collegeId);
        departmentRepo.save(department);
        DepartmentResponse departmentResponse=new DepartmentResponse();
        departmentResponse.setCollegeName(department.getCollege().getCollegeName());
        departmentResponse.setDepartmentName(department.getDepartmentName());
        departmentResponse.setDetails(department.getDetails());
        return departmentResponse;
    }


    @Override
    public Department getById(long id) {
        Department department=departmentRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("Department with " + id  +" not found")
        );

        return department;
    }

    @Override
    public List<DepartmentResponse> getAll() {
        return departmentRepo.findAll().stream()
                .map(department ->{DepartmentResponse departmentResponse=departmentMapper.fromEntityToResponseDto(department);
                    departmentResponse.setCollegeName(department.getCollege().getCollegeName());
                    return departmentResponse;
                })
                .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        checkThisIsFoundORThrowException(id);
        departmentRepo.deleteById(id);
        return new ResponseEntity<>("Department with " + id  +" is deleted",HttpStatus.ACCEPTED);
    }

    @Override
    public void checkThisIsFoundORThrowException(long id) {
        getById(id);

    }


}
