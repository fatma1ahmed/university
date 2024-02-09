package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentCommentPostResponse;
import com.fatma.university.model.entity.StudentComment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentCommentPostMapper {
    StudentComment toEntity(StudentCommentPostResponse studentCommentPostResponse);
    StudentCommentPostResponse fromEntityToResponseDto(StudentComment entity);
}
