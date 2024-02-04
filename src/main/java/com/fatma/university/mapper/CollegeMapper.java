package com.fatma.university.mapper;

import com.fatma.university.model.dto.CollegeRequest;
import com.fatma.university.model.dto.CollegeResponse;
import com.fatma.university.model.entity.College;
import org.mapstruct.Mapper;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public interface CollegeMapper  {
    College toEntity(CollegeRequest dto);
    CollegeResponse fromEntityToResponseDto(College entity);
}