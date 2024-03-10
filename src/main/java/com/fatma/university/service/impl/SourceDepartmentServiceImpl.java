package com.fatma.university.service.impl;

import com.fatma.university.mapper.SourceMapper;
import com.fatma.university.model.entity.College;
import com.fatma.university.model.entity.Department;
import com.fatma.university.model.entity.Source;
import com.fatma.university.service.CollegeService;
import com.fatma.university.service.DepartmentService;
import com.fatma.university.service.SourceDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SourceDepartmentServiceImpl implements SourceDepartmentService {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private SourceMapper sourceMapper;

    @Override
    public void assignSourceToDepartmentAndCollege(Source source,long departmentId,long collegeId)  {
       Department department=departmentService.getById(departmentId);
        College college=collegeService.getById(collegeId);
        source.setDepartment(department);
        source.setCollege(college);


    }

    @Override
    public void updateSource(Source source, long departmentId,long collegeId)  {
        Department exsistDepartment=departmentService.getById(departmentId);
        College exsistCollege=collegeService.getById(collegeId);
        source.setDepartment(exsistDepartment);
        source.setCollege(exsistCollege);

    }

    @Override
    public List<Source> getSourcesByDepartmentId(long departmentId) {
        Department exisitDepartment=departmentService.getById(departmentId);
        List<Source> sources=exisitDepartment.getSources();
        exisitDepartment.setSources(sources);
        return sources;
    }
}
