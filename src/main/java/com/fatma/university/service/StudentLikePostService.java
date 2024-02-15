package com.fatma.university.service;

import com.fatma.university.model.dto.StudentLikePostResponse;
import com.fatma.university.model.entity.StudentLike;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentLikePostService {
    public StudentLikePostResponse putLikeToPost(long studentId, long postId);

}
