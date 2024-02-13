package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentCommentPostResponse;
import com.fatma.university.model.entity.StudentComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentCommentPostMapper {
    StudentComment toEntity(StudentCommentPostResponse studentCommentPostResponse);
    @Mapping(target = "studentId",source = "studentComment.student.id")
    @Mapping(target = "postId",source = "studentComment.post.id")
    StudentCommentPostResponse toResponse(StudentComment studentComment);
}
