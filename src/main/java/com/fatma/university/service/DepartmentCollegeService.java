package com.fatma.university.service;

import com.fatma.university.model.dto.DepartmentRequest;
import com.fatma.university.model.dto.DepartmentResponse;

public interface DepartmentCollegeService {
    public DepartmentResponse assignDepartmentToCollege(DepartmentRequest departmentRequest);
    public DepartmentResponse updateDepartment(DepartmentRequest departmentRequest,long id);
}
