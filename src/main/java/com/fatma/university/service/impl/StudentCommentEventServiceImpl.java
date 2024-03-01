package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentCommentEventMapper;
import com.fatma.university.model.Enum.NotificationType;
import com.fatma.university.model.dto.StudentCommentEventResponse;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Notification;
import com.fatma.university.model.entity.Student;
import com.fatma.university.model.entity.StudentComment;
import com.fatma.university.reposity.NotificationRepo;
import com.fatma.university.reposity.StudentCommentRepo;
import com.fatma.university.service.EventService;
import com.fatma.university.service.StudentCommentEventService;
import com.fatma.university.service.StudentService;
import com.fatma.university.service.utils.NotificationBuilder;
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
    @Autowired
    private NotificationServiceImp notificationServiceImp;


    @Override
    public StudentCommentEventResponse putCommentToEvent(long studentId, long eventId, String comment) {
        Student student = studentService.getById(studentId);
        Event event = eventService.getById(eventId);
        Optional<StudentComment> studentComment = findCommentByStudentIdAndEventId(studentId, eventId);
        if (studentComment.isPresent()) {
            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(event.getSource(),
                                    NotificationType.EVENT,
                                    "لقد قام الطالب " + student.getFullName() + "ب تعديل التعليق علي الحدث ",
                                    studentId,
                                    eventId));
            return updateCommentToEvent(studentComment.get(), comment);

        } else {
            StudentComment createComment = new StudentComment();
            createComment.setStudent(student);
            createComment.setEvent(event);
            createComment.setComment(comment);

            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(event.getSource(),
                                    NotificationType.EVENT,
                                    "لقد قام الطالب " + student.getFullName() + "ب التعليق علي الحدث ",
                                    studentId,
                                    eventId));
            return studentCommentEventMapper.toResponse(studentCommentRepo.save(createComment));
        }
    }

    private StudentCommentEventResponse updateCommentToEvent(StudentComment studentComment, String comment) {
        studentComment.setComment(comment);
        return studentCommentEventMapper.toResponse(studentCommentRepo.save(studentComment));

    }

    private Optional<StudentComment> findCommentByStudentIdAndEventId(long studentId, long eventId) {
        return studentCommentRepo.findCommentByStudentIdAndEventId(studentId, eventId);
    }


}
