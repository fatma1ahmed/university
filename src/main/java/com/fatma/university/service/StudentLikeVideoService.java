package com.fatma.university.service;

import com.fatma.university.model.dto.StudentLikeVideoResponse;
import org.springframework.stereotype.Service;

@Service
public interface StudentLikeVideoService {
    public StudentLikeVideoResponse putLikeToVideo(long studentId, long videoId);
}
