package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentCommentPostMapper;
import com.fatma.university.model.dto.StudentCommentPostResponse;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Student;
import com.fatma.university.model.entity.StudentComment;
import com.fatma.university.reposity.StudentCommentRepo;
import com.fatma.university.service.PostService;
import com.fatma.university.service.StudentCommentPostService;
import com.fatma.university.service.StudentService;
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
    private StudentCommentPostMapper studentCommentPostMapper;
    @Override
    public StudentCommentPostResponse putCommentToPost(long studentId, long postId,String comment) {
        Student student=studentService.getById(studentId);
        Post post=postService.getById(postId);
        Optional<StudentComment> studentComment=findCommentByStudentIdAndPostId(studentId,postId);
        if(studentComment.isPresent()){
            return updateCommentToPost(studentComment.get(),comment);

        }else {
            StudentComment createComment=new StudentComment();
            createComment.setComment(comment);
            createComment.setStudent(student);
            createComment.setPost(post);
           return studentCommentPostMapper.toResponse(studentCommentRepo.save(createComment));
        }
    }
    private StudentCommentPostResponse updateCommentToPost(StudentComment studentComment,String comment){
        studentComment.setComment(comment);
        return studentCommentPostMapper.toResponse(studentCommentRepo.save(studentComment));
    }
    private Optional<StudentComment> findCommentByStudentIdAndPostId(long studentId, long postId) {
        return studentCommentRepo.findCommentByStudentIdAndPostId(studentId,postId);
    }
}
