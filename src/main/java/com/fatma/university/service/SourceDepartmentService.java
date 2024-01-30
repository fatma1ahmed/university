package com.fatma.university.service;

import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;

import java.io.IOException;

public interface SourceDepartmentService {
    public SourceResponse assignSourceToDepartment(SourceRequest sourceRequest) throws IOException;

    public SourceResponse updateSource(SourceRequest sourceRequest,long id) throws IOException;
}
