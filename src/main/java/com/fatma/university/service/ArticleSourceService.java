package com.fatma.university.service;

import com.fatma.university.model.entity.Article;
import org.springframework.stereotype.Service;

@Service
public interface ArticleSourceService {
    public void assignArticleToSource(Article article, long sourceId);
    public void updateSource(Article article,long sourceId) ;
}
