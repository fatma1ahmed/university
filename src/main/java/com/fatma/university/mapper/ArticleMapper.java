package com.fatma.university.mapper;

import com.fatma.university.model.dto.ArticleRequest;
import com.fatma.university.model.dto.ArticleResponse;
import com.fatma.university.model.entity.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    Article toEntity(ArticleRequest articleRequest);

    ArticleResponse fromEntityToResponseDto(Article entity);
}
