package com.fatma.university.mapper;

import com.fatma.university.model.dto.DepartmentRequest;
import com.fatma.university.model.dto.DepartmentResponse;
import com.fatma.university.model.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(DepartmentRequest dto);
    DepartmentResponse fromEntityToResponseDto(Department entity);
}