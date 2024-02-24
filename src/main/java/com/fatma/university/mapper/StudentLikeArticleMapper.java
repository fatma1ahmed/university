package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentLikeArticleResponse;
import com.fatma.university.model.entity.StudentLike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentLikeArticleMapper {
    StudentLike toEntity(StudentLikeArticleResponse studentLikeArticleResponse);
    @Mapping(target = "studentId" , source = "studentLike.student.id")
    @Mapping(target = "articleId",source = "studentLike.article.id")
    StudentLikeArticleResponse toResponse(StudentLike studentLike);
}
