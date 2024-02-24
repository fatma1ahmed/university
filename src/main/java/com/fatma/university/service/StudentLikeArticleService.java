package com.fatma.university.service;

import com.fatma.university.model.dto.StudentLikeArticleResponse;
import org.springframework.stereotype.Service;

@Service
public interface StudentLikeArticleService {
    public StudentLikeArticleResponse putLikeToArticle(long studentId, long articleId);
}
