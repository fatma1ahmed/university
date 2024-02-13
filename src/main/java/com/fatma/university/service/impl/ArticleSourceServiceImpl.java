package com.fatma.university.service.impl;

import com.fatma.university.model.entity.Article;
import com.fatma.university.model.entity.Source;
import com.fatma.university.service.ArticleSourceService;
import com.fatma.university.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleSourceServiceImpl implements ArticleSourceService {
    @Autowired
    private SourceService sourceService;
    @Override
    public void assignArticleToSource(Article article, long sourceId) {
        Source exisitSource=sourceService.getById(sourceId);
        article.setSource(exisitSource);
    }

    @Override
    public void updateSource(Article article, long sourceId) {
        Source exisitSource=sourceService.getById(sourceId);
        article.setSource(exisitSource);

    }
}
