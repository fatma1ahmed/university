package com.fatma.university.service;

import com.fatma.university.model.dto.CollegeRequest;
import com.fatma.university.model.dto.CollegeResponse;
import com.fatma.university.model.entity.College;
import org.springframework.stereotype.Service;

@Service
public interface CollegeService extends CrudService<College, CollegeRequest, CollegeResponse> {
}
