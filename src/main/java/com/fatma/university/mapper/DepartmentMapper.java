package com.fatma.university.mapper;

import com.fatma.university.model.dto.DepartmentRequest;
import com.fatma.university.model.dto.DepartmentResponse;
import com.fatma.university.model.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(DepartmentRequest departmentRequest);

    @Mapping(target = "collegeId"   , source = "department.college.id")
    DepartmentResponse toResponse(Department department);
}