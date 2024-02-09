package com.fatma.university.service;

import com.fatma.university.model.dto.ArticleRequest;
import com.fatma.university.model.dto.ArticleResponse;
import com.fatma.university.model.entity.Article;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService extends CrudService<Article, ArticleRequest, ArticleResponse> {

}
