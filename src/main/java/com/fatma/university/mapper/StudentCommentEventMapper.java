package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentCommentEventResponse;

import com.fatma.university.model.entity.StudentComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentCommentEventMapper {
    StudentComment toEntity(StudentCommentEventResponse studentCommentPostResponse);
    StudentCommentEventResponse fromEntityToResponseDto(StudentComment entity);
}
