package com.fatma.university.service.impl;

import com.fatma.university.mapper.SourceMapper;
import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.Department;
import com.fatma.university.model.entity.Source;
import com.fatma.university.service.DepartmentService;
import com.fatma.university.service.SourceDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SourceDepartmentServiceImpl implements SourceDepartmentService {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private SourceMapper sourceMapper;

    @Override
    public void assignSourceToDepartment(Source source,long departmentId) throws IOException {
       Department department=departmentService.getById(departmentId);
        source.setDepartment(department);


    }

    @Override
    public void updateSource(Source source, long departmentId) throws IOException {
        Department exsistDepartment=departmentService.getById(departmentId);
        source.setDepartment(exsistDepartment);

    }
}
