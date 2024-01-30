package com.fatma.university.mapper;

import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.Source;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SourceMapper {
    Source toEntity(SourceRequest sourceRequest);
    SourceResponse fromEntityToResponseDto(Source entity);
}