package com.fatma.university.service;

import com.fatma.university.model.dto.StudentCommentArticleResponse;
import org.springframework.stereotype.Service;

@Service
public interface StudentCommentArticleService {
    public StudentCommentArticleResponse putCommentToEvent(long studentId, long articleId, String comment);
}
