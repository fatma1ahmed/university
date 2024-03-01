package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.StudentCommentArticleMapper;
import com.fatma.university.model.Enum.NotificationType;
import com.fatma.university.model.dto.StudentCommentArticleResponse;
import com.fatma.university.model.entity.*;
import com.fatma.university.reposity.NotificationRepo;
import com.fatma.university.reposity.StudentCommentRepo;
import com.fatma.university.service.*;
import com.fatma.university.service.utils.NotificationBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCommentArticleServiceImpl implements StudentCommentArticleService {
    @Autowired
    private StudentCommentRepo studentCommentRepo;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private StudentCommentArticleMapper studentCommentArticleMapper;
    @Autowired
    private NotificationServiceImp notificationServiceImp;
    @Autowired
    private NotificationRepo notificationRepo;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public StudentCommentArticleResponse putCommentToArticle(long studentId, long articleId, String comment) {
        Student student = studentService.getById(studentId);
        Article article = articleService.getById(articleId);
        Source source = sourceService.getById(article.getSource().getId());
        Optional<StudentComment> studentComment = findCommentByStudentIdAndArticleId(studentId, articleId);
        if (studentComment.isPresent()) {
            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(source,
                                    NotificationType.ARTICLE,
                                    "لقد قام الطالب " + student.getFullName(),
                                    studentId,
                                    articleId));
            return updateCommentToArticle(studentComment.get(), comment);

        } else {
            StudentComment createComment = new StudentComment();
            createComment.setArticle(article);
            createComment.setStudent(student);
            createComment.setComment(comment);

            notificationServiceImp
                    .saveNotification(NotificationBuilder
                            .buildNotification(source,
                                    NotificationType.ARTICLE,
                                    "لقد قام الطالب " + student.getFullName() + "ب التعليق علي المقال ",
                                    studentId,
                                    articleId));

            return studentCommentArticleMapper.toResponse(studentCommentRepo.save(createComment));
        }
    }

    private StudentCommentArticleResponse updateCommentToArticle(StudentComment studentComment, String comment) {
        studentComment.setComment(comment);

        return studentCommentArticleMapper.toResponse(studentCommentRepo.save(studentComment));

    }

    private Optional<StudentComment> findCommentByStudentIdAndArticleId(long studentId, long articleId) {
        return studentCommentRepo.findCommentByStudentIdAndArticleId(studentId, articleId);
    }

    public StudentComment getById(long id) {
        return studentCommentRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this StudentComment with " + id + " not found")
        );
    }
}
