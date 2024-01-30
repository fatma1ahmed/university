package com.fatma.university.service.impl;

import com.fatma.university.mapper.DepartmentMapper;
import com.fatma.university.model.dto.DepartmentRequest;
import com.fatma.university.model.dto.DepartmentResponse;
import com.fatma.university.model.entity.College;
import com.fatma.university.model.entity.Department;
import com.fatma.university.service.DepartmentCollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentCollegeServiceImpl implements DepartmentCollegeService {
    @Autowired
    private CollegeServiceImpl collegeService;
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public DepartmentResponse assignDepartmentToCollege(DepartmentRequest departmentRequest) {
       College college=collegeService.getById(departmentRequest.getCollegeId());
        Department department=departmentMapper.toEntity(departmentRequest);
        department.setCollege(college);
      DepartmentResponse departmentResponse=new DepartmentResponse();
      departmentResponse.setCollegeName(college.getCollegeName());
      departmentResponse.setDepartmentName(department.getDepartmentName());
      departmentResponse.setDetails(department.getDetails());
        departmentService.add(department);
     return departmentResponse;
    }


    @Override
    public DepartmentResponse updateDepartment(DepartmentRequest departmentRequest,long id) {
        College existCollage=collegeService.getById(departmentRequest.getCollegeId());
        Department existDepartment=departmentService.getById(id);
     Department department=departmentMapper.toEntity(departmentRequest);
     department.setCollege(existCollage);
     department.setId(existDepartment.getId());
     departmentService.update(department,id);
     DepartmentResponse departmentResponse=new DepartmentResponse();
        departmentResponse.setCollegeName(existCollage.getCollegeName());
        departmentResponse.setDepartmentName(department.getDepartmentName());
        departmentResponse.setDetails(department.getDetails());


        return departmentResponse;
    }

}
