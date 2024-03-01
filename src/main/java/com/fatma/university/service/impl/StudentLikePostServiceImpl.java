package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentLikePostMapper;
import com.fatma.university.model.Enum.NotificationType;
import com.fatma.university.model.dto.StudentLikePostResponse;
import com.fatma.university.model.entity.*;
import com.fatma.university.reposity.NotificationRepo;
import com.fatma.university.reposity.StudentLikeRepo;
import com.fatma.university.service.PostService;
import com.fatma.university.service.SourceService;
import com.fatma.university.service.StudentLikePostService;
import com.fatma.university.service.StudentService;
import com.fatma.university.service.utils.NotificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentLikePostServiceImpl implements StudentLikePostService {
    @Autowired
    private StudentLikeRepo studentLikeRepo;
    @Autowired
    private StudentService studentService;
    @Autowired
    private PostService postService;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private StudentLikePostMapper studentLikePostMapper;
    @Autowired
    private NotificationServiceImp notificationServiceImp;
    @Override
    public StudentLikePostResponse putLikeToPost(long studentId, long postId) {
        Student student = studentService.getById(studentId);
        Post post = postService.getById(postId);
        Source source=sourceService.getById(post.getSource().getId());
        Optional<StudentLike> optionalStudentLike=findLikeByStudentIdAndPostId(studentId,postId);
        if(optionalStudentLike.isPresent()) {
            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(post.getSource(),
                                    NotificationType.POST,
                                    "لقد قام الطالب " + student.getFullName() + " ب الغاء الاعجاب علي منشور " ,
                                    studentId,
                                    postId));
            return convertLikeAndSaveIt(optionalStudentLike.get());
        }
      else  {
            StudentLike studentLike=new StudentLike();
            studentLike.setLike(true);
            studentLike.setStudent(student);
            studentLike.setPost(post);

            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(post.getSource(),
                                    NotificationType.POST,
                                    "لقد قام الطالب " + student.getFullName() + " ب  الاعجاب علي منشور" ,
                                    studentId,
                                    postId));

            return studentLikePostMapper.toResponse(studentLikeRepo.save(studentLike));
        }
    }
private StudentLikePostResponse convertLikeAndSaveIt(StudentLike studentLike){
        studentLike.setLike(!studentLike.isLike());
    return studentLikePostMapper.toResponse(studentLikeRepo.save(studentLike));
}

    private Optional<StudentLike> findLikeByStudentIdAndPostId(long studentId, long postId) {
        return studentLikeRepo.findLikeByStudentIdAndPostId(studentId,postId);
    }
}
