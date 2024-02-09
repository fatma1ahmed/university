package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentLikePostResponse;
import com.fatma.university.model.entity.StudentLike;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentLikePostMapper {
    StudentLike toEntity(StudentLikePostResponse studentLikePostResponse);
    StudentLikePostResponse fromEntityToResponseDto(StudentLike entity);
}
