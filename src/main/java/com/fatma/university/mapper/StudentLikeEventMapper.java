package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentLikeEventResponse;
import com.fatma.university.model.entity.StudentLike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentLikeEventMapper {


    StudentLike toEntity(StudentLikeEventResponse studentLikeEventResponse);
    @Mapping(target = "studentId" , source = "studentLike.student.id")
    @Mapping(target = "eventId" , source = "studentLike.event.id")
    StudentLikeEventResponse fromEntityToResponseDto(StudentLike studentLike);
}





