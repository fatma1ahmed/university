package com.fatma.university.service.impl;

import com.fatma.university.mapper.UpdateStudentMapper;
import com.fatma.university.model.dto.UpdateStudentRequest;
import com.fatma.university.model.dto.UpdateStudentResponse;
import com.fatma.university.model.entity.College;
import com.fatma.university.model.entity.Department;
import com.fatma.university.model.entity.Student;
import com.fatma.university.repository.StudentRepo;
import com.fatma.university.service.CollegeService;
import com.fatma.university.service.DepartmentService;
import com.fatma.university.service.StudentCollegeDepartmentService;
import com.fatma.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCollegeDepartmentServiceImpl implements StudentCollegeDepartmentService {
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UpdateStudentMapper updateStudentMapper;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ImageServiceImpl imageService;

    @Override
    public UpdateStudentResponse UpdateStudentData(UpdateStudentRequest updateStudentRequest, long studentId, long collegeId, long departmentId) {
        College college=collegeService.getById(collegeId);
        Department department=departmentService.getById(departmentId);
        Student exsistStudent=studentService.getById(studentId);
        Student student=updateStudentMapper.toEntity(updateStudentRequest);
        student.setDepartment(department);
        student.setCollege(college);
        student.setId(studentId);
//        student.setImagePath(imageService.saveImageToBase64(student.getImagePath()));
        return updateStudentMapper.toResponse(studentRepo.save(student));
    }
}
