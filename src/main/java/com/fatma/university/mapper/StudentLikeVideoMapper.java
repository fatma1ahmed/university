package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentLikeArticleResponse;
import com.fatma.university.model.dto.StudentLikeVideoResponse;
import com.fatma.university.model.entity.StudentLike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentLikeVideoMapper {
    StudentLike toEntity(StudentLikeVideoResponse studentLikeVideoResponse);
    @Mapping(target = "studentId" , source = "studentLike.student.id")
    @Mapping(target = "videoId",source = "studentLike.video.id")
    StudentLikeVideoResponse toResponse(StudentLike studentLike);
}
