package com.fatma.university.mapper;

import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.Source;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SourceMapper {
    Source toEntity(SourceRequest sourceRequest);

    @Mapping(target = "departmentId" , source = "source.department.id")
    SourceResponse toResponse(Source source);
}