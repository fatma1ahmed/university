package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentRequest;
import com.fatma.university.model.dto.StudentResponse;
import com.fatma.university.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentRequest studentRequest);


//    @Mapping(target = "collegeId" , source = "student.college.id")
    @Mapping(target = "departmentId" , source = "student.department.id")
    StudentResponse toResponse(Student student);

}
