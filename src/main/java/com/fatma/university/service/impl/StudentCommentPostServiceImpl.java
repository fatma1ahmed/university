package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentCommentPostMapper;
import com.fatma.university.model.Enum.NotificationType;
import com.fatma.university.model.dto.StudentCommentPostResponse;
import com.fatma.university.model.entity.*;
import com.fatma.university.repository.StudentCommentRepo;
import com.fatma.university.service.PostService;
import com.fatma.university.service.SourceService;
import com.fatma.university.service.StudentCommentPostService;
import com.fatma.university.service.StudentService;
import com.fatma.university.service.utils.NotificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCommentPostServiceImpl implements StudentCommentPostService {
    @Autowired
    private StudentCommentRepo studentCommentRepo;
    @Autowired
    private StudentService studentService;
    @Autowired
    private PostService postService;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private StudentCommentPostMapper studentCommentPostMapper;
    @Autowired
    private NotificationServiceImp notificationArticleService;
    @Autowired
    private NotificationServiceImp notificationServiceImp;

    @Override
    public StudentCommentPostResponse putCommentToPost(long studentId, long postId, String comment) {
        Student student = studentService.getById(studentId);
        Post post = postService.getById(postId);
        Source source = sourceService.getById(post.getSource().getId());

        Optional<StudentComment> studentComment = findCommentByStudentIdAndPostId(studentId, postId);
        if (studentComment.isPresent()) {
            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(post.getSource(),
                                    NotificationType.POST,
                                    "لقد قام الطالب " + student.getFullName() + "ب تعديل التعليق علي البوست ",
                                    student.getId(),
                                    post.getId()));
            return updateCommentToPost(studentComment.get(), comment);

        } else {
            StudentComment createComment = new StudentComment();
            createComment.setComment(comment);
            createComment.setStudent(student);
            createComment.setPost(post);

            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(post.getSource(),
                                    NotificationType.POST,
                                    "لقد قام الطالب " + student.getFullName() + "ب التعليق علي منشور ",
                                    studentId,
                                    postId));

            return studentCommentPostMapper.toResponse(studentCommentRepo.save(createComment));
        }
    }

    private StudentCommentPostResponse updateCommentToPost(StudentComment studentComment, String comment) {
        studentComment.setComment(comment);
        return studentCommentPostMapper.toResponse(studentCommentRepo.save(studentComment));
    }

    private Optional<StudentComment> findCommentByStudentIdAndPostId(long studentId, long postId) {
        return studentCommentRepo.findCommentByStudentIdAndPostId(studentId, postId);
    }
}
