package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentCommentEventMapper;
import com.fatma.university.model.dto.StudentCommentEventResponse;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Student;
import com.fatma.university.model.entity.StudentComment;
import com.fatma.university.reposity.StudentCommentRepo;
import com.fatma.university.service.EventService;
import com.fatma.university.service.StudentCommentEventService;
import com.fatma.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCommentEventServiceImpl implements StudentCommentEventService {
    @Autowired
    private StudentCommentRepo studentCommentRepo;
    @Autowired
    private StudentService studentService;
    @Autowired
    private EventService eventService;
    @Autowired
    private StudentCommentEventMapper studentCommentEventMapper;

    @Override
    public StudentCommentEventResponse putCommentToEvent(long studentId, long eventId, String comment) {
        Student student=studentService.getById(studentId);
        Event event = eventService.getById(eventId);
        Optional<StudentComment> studentComment=findCommentByStudentIdAndEventId(studentId,eventId);
        if(studentComment.isPresent()){
            return updateCommentToEvent(studentId, eventId, comment);

        }else {
            StudentCommentEventResponse createComment=new StudentCommentEventResponse();
            createComment.setStudentName(student.getFullName());
            createComment.setEventAddress(event.getAddress());
            createComment.setComment(comment);
            createComment.setEvent(event);
            createComment.setStudent(student);
            StudentComment savedComment = studentCommentRepo.save(studentCommentEventMapper.toEntity(createComment));
            createComment.setId(savedComment.getId());
            return createComment ;

        }

    }

    @Override
    public StudentCommentEventResponse updateCommentToEvent(long studentId, long eventId, String comment) {
        Student student = studentService.getById(studentId);
        Event event = eventService.getById(eventId);
        Optional<StudentComment> studentComment = findCommentByStudentIdAndEventId(studentId, eventId);
        StudentCommentEventResponse existStudentComment = studentCommentEventMapper.fromEntityToResponseDto(studentComment.get());
        if (studentComment.isPresent()) {
            existStudentComment.setComment(comment);
            existStudentComment.setEventAddress(event.getAddress());
            existStudentComment.setStudentName(student.getFullName());
            studentCommentRepo.save(studentCommentEventMapper.toEntity(existStudentComment));
        }
        return existStudentComment;
    }

    @Override
    public Optional<StudentComment> findCommentByStudentIdAndEventId(long studentId, long eventId) {
        return studentCommentRepo.findCommentByStudentIdAndEventId(studentId,eventId);
    }


}
