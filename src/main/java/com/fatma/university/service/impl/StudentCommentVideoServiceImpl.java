package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentCommentVideoMapper;
import com.fatma.university.model.Enum.NotificationType;
import com.fatma.university.model.dto.StudentCommentVideoResponse;
import com.fatma.university.model.entity.*;
import com.fatma.university.reposity.NotificationRepo;
import com.fatma.university.reposity.StudentCommentRepo;
import com.fatma.university.service.SourceService;
import com.fatma.university.service.StudentCommentVideoService;
import com.fatma.university.service.StudentService;
import com.fatma.university.service.VideoService;
import com.fatma.university.service.utils.NotificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCommentVideoServiceImpl implements StudentCommentVideoService {
    @Autowired
    private StudentCommentRepo studentCommentRepo;
    @Autowired
    private StudentService studentService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private NotificationServiceImp notificationServiceImp;
    @Autowired
    private StudentCommentVideoMapper studentCommentVideoMapper;



    @Override
    public StudentCommentVideoResponse putCommentToVideo(long studentId, long videoId, String comment) {
        Student student = studentService.getById(studentId);
        Video video = videoService.getById(videoId);
        Source source=sourceService.getById(video.getSource().getId());
        Optional<StudentComment> studentComment = findCommentByStudentIdAndVideoId(studentId, videoId);
        if (studentComment.isPresent()) {
            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(video.getSource(),
                                    NotificationType.VIDEO,
                                    "لقد قام الطالب " + student.getFullName() + "ب اعاده التعليق علي فيديو " ,
                                    studentId,
                                    videoId));
            return updateCommentToVideo(studentComment.get(), comment);
        } else {
            StudentComment createComment = new StudentComment();
            createComment.setVideo(video);
            createComment.setStudent(student);
            createComment.setComment(comment);

//            Notification notification=new Notification();
//            notification.setMessage("Student By Id: " + studentId + " add comment on Article By Id " + videoId);
//            notification.setSource(source);
//            notification.setPostId(videoId);
//            notification.setStudentId(studentId);
//            notification.setNotificationType(NotificationType.ARTICLE);
//            notificationRepo.save(notification);
//            createComment.setNotification(notification);
            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(video.getSource(),
                                    NotificationType.VIDEO,
                                    "لقد قام الطالب " + student.getFullName() + "ب التعليق علي فيديو " ,
                                    studentId,
                                    videoId));
            return studentCommentVideoMapper.toResponse(studentCommentRepo.save(createComment));
        }
    }
    private StudentCommentVideoResponse updateCommentToVideo(StudentComment studentComment, String comment){
        studentComment.setComment(comment);
        return studentCommentVideoMapper.toResponse(studentCommentRepo.save(studentComment));

    }
    private Optional<StudentComment> findCommentByStudentIdAndVideoId(long studentId, long videoId){
        return studentCommentRepo.findCommentByStudentIdAndVideoId(studentId,videoId);
    }
}
