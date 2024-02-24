package com.fatma.university.service;

import com.fatma.university.model.dto.StudentCommentVideoResponse;
import org.springframework.stereotype.Service;

@Service
public interface StudentCommentVideoService {
    StudentCommentVideoResponse putCommentToVideo(long studentId, long videoId, String comment);
}
