package com.fatma.university.service;

import com.fatma.university.model.dto.UpdateStudentRequest;
import com.fatma.university.model.dto.UpdateStudentResponse;
import com.fatma.university.model.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentCollegeDepartmentService {
     UpdateStudentResponse UpdateStudentData(UpdateStudentRequest updateStudentRequest, long studentId, long collegeId, long departmentId);
}
