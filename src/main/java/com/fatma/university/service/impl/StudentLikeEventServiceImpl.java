package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentLikeEventMapper;
import com.fatma.university.mapper.StudentLikePostMapper;
import com.fatma.university.model.dto.StudentLikeEventResponse;
import com.fatma.university.model.dto.StudentLikePostResponse;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Student;
import com.fatma.university.model.entity.StudentLike;
import com.fatma.university.reposity.StudentLikeRepo;
import com.fatma.university.service.EventService;
import com.fatma.university.service.PostService;
import com.fatma.university.service.StudentLikeEventService;
import com.fatma.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentLikeEventServiceImpl implements StudentLikeEventService {
    @Autowired
    private StudentLikeRepo studentLikeRepo;
    @Autowired
    private StudentService studentService;
    @Autowired
    private EventService eventService;
    @Autowired
    private StudentLikeEventMapper studentLikeEventMapper;

    @Override
    public StudentLikeEventResponse putLikeToEvent(long studentId, long eventId) {
        Student student = studentService.getById(studentId);
        Event event = eventService.getById(eventId);
        Optional<StudentLike> studentLike=findLikeByStudentIdAndEventId(studentId,eventId);
        if(studentLike.isPresent()){
            return updateLikeToEvent(studentId,eventId);
        }else {
            StudentLikeEventResponse createLike=new StudentLikeEventResponse();
            createLike.setLike(true);
            createLike.setStudent(student);
            createLike.setEvent(event);
            createLike.setEventAddress(event.getAddress());
            createLike.setStudentName(student.getFullName());
            StudentLike savedLike=studentLikeRepo.save(studentLikeEventMapper.toEntity(createLike));
            createLike.setId(savedLike.getId());
            return createLike;
        }
    }

    @Override
    public StudentLikeEventResponse updateLikeToEvent(long studentId, long eventId) {
        Student student = studentService.getById(studentId);
        Event event = eventService.getById(eventId);
        Optional<StudentLike> studentLike=findLikeByStudentIdAndEventId(studentId,eventId);
        StudentLikeEventResponse existLike=studentLikeEventMapper.fromEntityToResponseDto(studentLike.get());
        if(studentLike.isPresent()){
            boolean currentLike=existLike.isLike();
            existLike.setLike(!currentLike);
            existLike.setEventAddress(event.getAddress());
            existLike.setStudentName(student.getFullName());
            studentLikeRepo.save(studentLikeEventMapper.toEntity(existLike));
        }

        return existLike;
    }

    @Override
    public Optional<StudentLike> findLikeByStudentIdAndEventId(long studentId, long eventId) {
        return studentLikeRepo.findIsLikeByStudentIdAndEventId(studentId,eventId);
    }
}
