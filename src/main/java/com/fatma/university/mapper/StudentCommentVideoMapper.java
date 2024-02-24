package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentCommentVideoResponse;
import com.fatma.university.model.entity.StudentComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentCommentVideoMapper {
    StudentComment toEntity(StudentCommentVideoResponse studentCommentVideoResponse);
    @Mapping(target = "studentId",source = "studentComment.student.id")
    @Mapping(target = "videoId",source = "studentComment.video.id")
    StudentCommentVideoResponse toResponse(StudentComment studentComment);
}
