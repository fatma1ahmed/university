package com.fatma.university.service.impl;

import com.fatma.university.mapper.SourceMapper;
import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.Department;
import com.fatma.university.model.entity.Source;
import com.fatma.university.service.SourceDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SourceDepartmentServiceImpl implements SourceDepartmentService {
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private SourceServiceImpl sourceService;
    @Autowired
    private SourceMapper sourceMapper;

    @Override
    public SourceResponse assignSourceToDepartment(SourceRequest sourceRequest) throws IOException {
       Department department=departmentService.getById(sourceRequest.getDepartmentId());
        Source source=sourceMapper.toEntity(sourceRequest);
        source.setDepartment(department);
        SourceResponse sourceResponse=new SourceResponse();
        sourceResponse.setFullName(source.getFullName());
        sourceResponse.setEmail(source.getEmail());
        sourceResponse.setDepartmentName(department.getDepartmentName());
        sourceResponse.setDepartment(department);
        sourceService.add(source);
        return sourceResponse;
    }

    @Override
    public SourceResponse updateSource(SourceRequest sourceRequest, long id) throws IOException {
        Department exsistDepartment=departmentService.getById(sourceRequest.getDepartmentId());
        Source exisistSource=sourceService.getById(id);
        Source source=sourceMapper.toEntity(sourceRequest);
        source.setId(exisistSource.getId());
        source.setDepartment(exsistDepartment);
        sourceService.update(source,id);
        SourceResponse sourceResponse=new SourceResponse();
        sourceResponse.setDepartmentName(exsistDepartment.getDepartmentName());
        sourceResponse.setFullName(exisistSource.getFullName());
        sourceResponse.setEmail(exisistSource.getEmail());

        return sourceResponse;
    }
}
