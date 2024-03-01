package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentLikeVideoMapper;
import com.fatma.university.model.Enum.NotificationType;
import com.fatma.university.model.dto.StudentLikeVideoResponse;
import com.fatma.university.model.entity.*;
import com.fatma.university.reposity.NotificationRepo;
import com.fatma.university.reposity.StudentLikeRepo;
import com.fatma.university.service.SourceService;
import com.fatma.university.service.StudentLikeVideoService;
import com.fatma.university.service.StudentService;
import com.fatma.university.service.VideoService;
import com.fatma.university.service.utils.NotificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentLikeVideoServiceImpl implements StudentLikeVideoService {
    @Autowired
    private StudentLikeRepo studentLikeRepo;
    @Autowired
    private StudentService studentService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private StudentLikeVideoMapper studentLikeVideoMapper;
    @Autowired
    private NotificationServiceImp  notificationServiceImp;

    @Override
    public StudentLikeVideoResponse putLikeToVideo(long studentId, long videoId) {
        Student student = studentService.getById(studentId);
        Video video = videoService.getById(videoId);
        Source source=sourceService.getById(video.getSource().getId());
        Optional<StudentLike> studentLike=findIsLikeByStudentIdAndVideoId(studentId,videoId);
        if(studentLike.isPresent()) {
            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(video.getSource(),
                                    NotificationType.VIDEO,
                                    "لقد قام الطالب " + student.getFullName() + " ب الغاء الاعجاب علي فيديو " ,
                                    studentId,
                                    videoId));
            return convertLikeAndSaveIt(studentLike.get());
        }
        else  {
            StudentLike studentLike1=new StudentLike();
            studentLike1.setLike(true);
            studentLike1.setStudent(student);
            studentLike1.setVideo(video);


            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(video.getSource(),
                                    NotificationType.VIDEO,
                                    "لقد قام الطالب " + student.getFullName() + " ب  الاعجاب علي فيديو " ,
                                    studentId,
                                    videoId));

            return studentLikeVideoMapper.toResponse(studentLikeRepo.save(studentLike1));
        }
    }
    private StudentLikeVideoResponse convertLikeAndSaveIt(StudentLike studentLike){
        studentLike.setLike(!studentLike.isLike());
        return studentLikeVideoMapper.toResponse(studentLikeRepo.save(studentLike));
    }

    private Optional<StudentLike> findIsLikeByStudentIdAndVideoId(long studentId, long videoId) {
        return studentLikeRepo.findIsLikeByStudentIdAndVideoId(studentId,videoId);
    }
}
