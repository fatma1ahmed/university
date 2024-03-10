package com.fatma.university.service;

import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Source;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Service
public interface SourceDepartmentService {
    public void assignSourceToDepartmentAndCollege(Source source,long departmentId,long collegeId);

    public void updateSource(Source source, long departmentId,long collegeId) ;

    public  List<Source> getSourcesByDepartmentId(long departmentId) ;
}


