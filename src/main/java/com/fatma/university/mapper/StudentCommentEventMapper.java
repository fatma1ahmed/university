package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentCommentEventResponse;

import com.fatma.university.model.entity.StudentComment;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface StudentCommentEventMapper {
    StudentComment toEntity(StudentCommentEventResponse studentCommentPostResponse);


    @Mapping(target = "studentId",source = "studentComment.student.id")
    @Mapping(target = "eventId",source = "studentComment.event.id")
    StudentCommentEventResponse toResponse(StudentComment studentComment);

}
