package com.fatma.university.service.impl;


import com.fatma.university.mapper.StudentLikeEventMapper;
import com.fatma.university.model.Enum.NotificationType;
import com.fatma.university.model.dto.StudentLikeEventResponse;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Notification;
import com.fatma.university.model.entity.Student;
import com.fatma.university.model.entity.StudentLike;
import com.fatma.university.reposity.NotificationRepo;
import com.fatma.university.reposity.StudentLikeRepo;
import com.fatma.university.service.EventService;
import com.fatma.university.service.StudentLikeEventService;
import com.fatma.university.service.StudentService;
import com.fatma.university.service.utils.NotificationBuilder;
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
    @Autowired
    private NotificationServiceImp notificationServiceImp;

    @Override
    public StudentLikeEventResponse putLikeToEvent(long studentId, long eventId) {
        Student student = studentService.getById(studentId);
        Event event = eventService.getById(eventId);

        Optional<StudentLike> optionalStudentLike = findLikeByStudentIdAndEventId(studentId, eventId);
        if (optionalStudentLike.isPresent()) {
            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(event.getSource(),
                                    NotificationType.EVENT,
                                    "لقد قام الطالب " + student.getFullName() + " ب الغاء الاعجاب علي " + event.getAddress(),
                                    studentId,
                                    eventId));
            return convertLikeAndSaveIt(optionalStudentLike.get());
        } else {
            StudentLike studentLike = new StudentLike();
            studentLike.setLike(true);
            studentLike.setStudent(student);
            studentLike.setEvent(event);

            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(event.getSource(),
                                    NotificationType.EVENT,
                                    "لقد قام الطالب " + student.getFullName() + " ب  الاعجاب علي " + event.getAddress(),
                                    studentId,
                                    eventId));

            return studentLikeEventMapper.fromEntityToResponseDto(studentLikeRepo.save(studentLike));
        }
    }

    private StudentLikeEventResponse convertLikeAndSaveIt(StudentLike studentLike) {
        studentLike.setLike(!studentLike.isLike());
        return studentLikeEventMapper.
                fromEntityToResponseDto(studentLikeRepo.save(studentLike));
    }

    private Optional<StudentLike> findLikeByStudentIdAndEventId(long studentId, long eventId) {
        return studentLikeRepo.findIsLikeByStudentIdAndEventId(studentId,eventId);

    }
}
