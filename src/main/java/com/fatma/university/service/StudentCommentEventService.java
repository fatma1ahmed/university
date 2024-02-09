package com.fatma.university.service;

import com.fatma.university.model.dto.StudentCommentEventResponse;
import com.fatma.university.model.dto.StudentCommentPostResponse;
import com.fatma.university.model.entity.StudentComment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentCommentEventService {
    public StudentCommentEventResponse putCommentToEvent(long studentId, long eventId, String comment);
    public StudentCommentEventResponse updateCommentToEvent(long studentId, long eventId, String comment);
    Optional<StudentComment> findCommentByStudentIdAndEventId(long studentId,long eventId);
}
