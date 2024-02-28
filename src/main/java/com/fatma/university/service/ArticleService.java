package com.fatma.university.service;

import com.fatma.university.model.dto.ArticleRequest;
import com.fatma.university.model.dto.ArticleResponse;
import com.fatma.university.model.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService extends CrudService<Article, ArticleRequest, ArticleResponse> {

    List<ArticleResponse> getAllForDepartment(long departmentId);
}
