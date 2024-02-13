package com.fatma.university.mapper;

import com.fatma.university.model.dto.ArticleRequest;
import com.fatma.university.model.dto.ArticleResponse;
import com.fatma.university.model.entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    Article toEntity(ArticleRequest articleRequest);

    @Mapping(target = "sourceId"  , source = "article.source.id")
    ArticleResponse toResponse(Article article);
}
