package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentLikeArticleMapper;
import com.fatma.university.model.Enum.NotificationType;
import com.fatma.university.model.dto.StudentLikeArticleResponse;
import com.fatma.university.model.entity.*;
import com.fatma.university.reposity.NotificationRepo;
import com.fatma.university.reposity.StudentLikeRepo;
import com.fatma.university.service.ArticleService;
import com.fatma.university.service.SourceService;
import com.fatma.university.service.StudentLikeArticleService;
import com.fatma.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentLikeArticleServiceImpl implements StudentLikeArticleService {
    @Autowired
    private StudentLikeRepo studentLikeRepo;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private StudentLikeArticleMapper studentLikeArticleMapper;
    @Autowired
    private NotificationLikeServiceImpl notificationLikeService;
    @Autowired
    private NotificationRepo notificationRepo;
    @Override
    public StudentLikeArticleResponse putLikeToArticle(long studentId, long articleId) {
        Student student = studentService.getById(studentId);
        Article article = articleService.getById(articleId);
        Source source=sourceService.getById(article.getSource().getId());
        Optional<StudentLike> studentLike = findIsLikeByStudentIdAndArticleId(studentId, articleId);
        if (studentLike.isPresent()) {
            return convertLikeAndSaveIt(studentLike.get());
        }else {
            StudentLike createLike = new StudentLike();
            createLike.setLike(true);
            createLike.setStudent(student);
            createLike.setArticle(article);

            Notification notification=new Notification();
            notification.setMessage("Student By Id: " + studentId + " add Like on Article By Id " + articleId);
            notification.setSource(source);
            notification.setArticleId(articleId);
            notification.setStudentId(studentId);
            notification.setNotificationType(NotificationType.ARTICLE);
            notificationRepo.save(notification);
            createLike.setNotification(notification);
            return studentLikeArticleMapper.toResponse(studentLikeRepo.save(createLike));
        }
    }
    private StudentLikeArticleResponse convertLikeAndSaveIt(StudentLike studentLike) {
        studentLike.setLike(!studentLike.isLike());
        notificationLikeService.updateNotificationArticle(studentLike.getNotification());
        return studentLikeArticleMapper.toResponse(studentLikeRepo.save(studentLike));
    }

    private Optional<StudentLike> findIsLikeByStudentIdAndArticleId(long studentId, long articleId) {
        return studentLikeRepo.findIsLikeByStudentIdAndArticleId(studentId,articleId);

    }
}
