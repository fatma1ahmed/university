package com.fatma.university.mapper;

import com.fatma.university.model.dto.StudentCommentArticleResponse;
import com.fatma.university.model.dto.StudentLikeArticleResponse;
import com.fatma.university.model.entity.StudentComment;
import com.fatma.university.model.entity.StudentLike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface StudentCommentArticleMapper {
    StudentComment toEntity(StudentCommentArticleResponse studentCommentArticleResponse);
    @Mapping(target = "studentId" , source = "studentComment.student.id")
    @Mapping(target = "articleId",source = "studentComment.article.id")
    StudentCommentArticleResponse toResponse(StudentComment studentComment);
}
