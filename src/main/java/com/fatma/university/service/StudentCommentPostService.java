package com.fatma.university.service;

import com.fatma.university.model.dto.StudentCommentPostResponse;
import com.fatma.university.model.entity.StudentComment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentCommentPostService {
    public StudentCommentPostResponse putCommentToPost(long studentId, long postId,String comment);
}
