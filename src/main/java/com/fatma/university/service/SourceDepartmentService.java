package com.fatma.university.service;

import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.Source;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface SourceDepartmentService {
    public void assignSourceToDepartment(Source source, long departmentId) throws IOException ;

    public void updateSource(Source source, long departmentId) throws IOException;
}
