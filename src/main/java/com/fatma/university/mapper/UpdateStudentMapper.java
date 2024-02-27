package com.fatma.university.mapper;

import com.fatma.university.model.dto.UpdateStudentRequest;
import com.fatma.university.model.dto.UpdateStudentResponse;
import com.fatma.university.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UpdateStudentMapper {
    Student toEntity(UpdateStudentRequest updateStudentRequest);
    @Mapping(target = "collegeId" , source = "student.college.id")
    @Mapping(target = "departmentId" , source = "student.department.id")
    UpdateStudentResponse toResponse(Student student);
}
