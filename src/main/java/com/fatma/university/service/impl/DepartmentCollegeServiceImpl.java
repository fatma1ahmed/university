package com.fatma.university.service.impl;

import com.fatma.university.mapper.DepartmentMapper;
import com.fatma.university.model.dto.DepartmentResponse;
import com.fatma.university.model.entity.College;
import com.fatma.university.model.entity.Department;
import com.fatma.university.service.CollegeService;
import com.fatma.university.service.DepartmentCollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentCollegeServiceImpl implements DepartmentCollegeService {
    @Autowired
    private CollegeService collegeService;

    @Override
    public void assignDepartmentToCollege(Department department,long CollegeId) {
        College exisitCollege=collegeService.getById(CollegeId);
        department.setCollege(exisitCollege);
    }

    @Override
    public void updateDepartment(Department department, long collegeId) {
        College exsistCollege=collegeService.getById(collegeId);
        department.setCollege(exsistCollege);
    }

    @Override
    public List<Department> getDepartmentsByCollegeId(long collegeId) {
        College exsistCollege=collegeService.getById(collegeId);
        List<Department> departments=exsistCollege.getDepartments();
        exsistCollege.setDepartments(departments);
        return departments;
    }


}
