package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentRequest;
import com.fatma.university.model.dto.StudentResponse;
import com.fatma.university.model.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentRequest studentRequest);
    StudentResponse fromEntityToResponseDto(Student entity);
}
