package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentLikePostResponse;
import com.fatma.university.model.entity.StudentLike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface StudentLikePostMapper {
    StudentLike toEntity(StudentLikePostResponse studentLikePostResponse);

    StudentLikePostResponse fromEntityToResponseDto(StudentLike entity);

    @Mapping(target = "studentId",source = "studentLike.student.id")
    @Mapping(target = "postId",source = "studentLike.post.id")
    StudentLikePostResponse toResponse(StudentLike studentLike);

}
