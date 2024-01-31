package com.fatma.university.service;

import com.fatma.university.model.dto.DepartmentResponse;
import com.fatma.university.model.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentCollegeService {
    public void assignDepartmentToCollege(Department department,long CollegeId);
    public void updateDepartment(Department department,long id) ;
    public List<Department> getDepartmentsByCollegeId(long collegeId);

}
