package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentCommentArticleMapper;
import com.fatma.university.model.dto.StudentCommentArticleResponse;
import com.fatma.university.model.entity.*;
import com.fatma.university.reposity.NotificationRepo;
import com.fatma.university.reposity.StudentCommentRepo;
import com.fatma.university.service.ArticleService;
import com.fatma.university.service.SourceService;
import com.fatma.university.service.StudentCommentArticleService;
import com.fatma.university.service.StudentService;
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
    private NotificationRepo notificationRepo;
    @Override
    public StudentCommentArticleResponse putCommentToEvent(long studentId, long articleId, String comment) {
        Student student = studentService.getById(studentId);
        Article article = articleService.getById(articleId);
        Source source=sourceService.getById(article.getSource().getId());
        Optional<StudentComment> studentComment = findCommentByStudentIdAndArticleId(studentId, articleId);
        if (studentComment.isPresent()) {
           return updateCommentToArticle(studentComment.get(), comment);
        } else {
            StudentComment createComment = new StudentComment();
            createComment.setArticle(article);
            createComment.setStudent(student);
            createComment.setComment(comment);
            Notification notification=new Notification();
            notification.setMessage("Student By Id: " + studentId + " add comment on Article By Id " + articleId);
            notification.setSource(source);
            notificationRepo.save(notification);
            return studentCommentArticleMapper.toResponse(studentCommentRepo.save(createComment));
        }
    }
    private StudentCommentArticleResponse updateCommentToArticle(StudentComment studentComment, String comment){
        studentComment.setComment(comment);
        return studentCommentArticleMapper.toResponse(studentCommentRepo.save(studentComment));

    }
    private Optional<StudentComment> findCommentByStudentIdAndArticleId(long studentId,long articleId){
        return studentCommentRepo.findCommentByStudentIdAndArticleId(studentId,articleId);
    }
}
