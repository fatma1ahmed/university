package com.fatma.university.service;

import com.fatma.university.model.dto.StudentLikeEventResponse;
import com.fatma.university.model.entity.StudentLike;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentLikeEventService {



    public StudentLikeEventResponse putLikeToEvent(long studentId, long eventId);



}
