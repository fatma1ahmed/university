package com.fatma.university.service;

import com.fatma.university.model.dto.StudentRequest;
import com.fatma.university.model.dto.StudentResponse;
import com.fatma.university.model.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService extends CrudService<Student, StudentRequest, StudentResponse> {
}
