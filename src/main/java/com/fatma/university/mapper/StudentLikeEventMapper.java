package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentLikeEventResponse;
import com.fatma.university.model.entity.StudentLike;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentLikeEventMapper {
    StudentLike toEntity(StudentLikeEventResponse studentLikeEventResponse);
    StudentLikeEventResponse fromEntityToResponseDto(StudentLike entity);
}
