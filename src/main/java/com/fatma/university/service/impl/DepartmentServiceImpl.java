package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.DepartmentMapper;
import com.fatma.university.model.dto.DepartmentResponse;
import com.fatma.university.model.entity.Department;
import com.fatma.university.reposity.DepartmentRepo;
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

    @Override
    public DepartmentResponse add(Department department) {
        Department savedDepartment=departmentRepo.save(department);
        DepartmentResponse departmentResponse=departmentMapper.fromEntityToResponseDto(savedDepartment);

        return  departmentResponse;

    }
    @Override
    public DepartmentResponse update(Department department,long id){
        checkThisIsFoundORThrowException(id);
        Department updateDepartment=departmentRepo.save(department);
        DepartmentResponse departmentResponse=departmentMapper.fromEntityToResponseDto(updateDepartment);
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
                .map(department -> departmentMapper.fromEntityToResponseDto(department))
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
