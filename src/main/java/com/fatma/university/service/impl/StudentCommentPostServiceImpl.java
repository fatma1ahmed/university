package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotCorrectException;
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
            return updateCommentToPost(studentId, postId, comment);

        }else {
            StudentCommentPostResponse createComment=new StudentCommentPostResponse();
            createComment.setStudentId(student.getId());
            createComment.setPostId(post.getId());
            createComment.setComment(comment);
            StudentComment savedComment = studentCommentRepo.save(studentCommentPostMapper.toEntity(createComment));
            createComment.setId(savedComment.getId());
            return createComment ;

        }

    }
    @Override
    public StudentCommentPostResponse updateCommentToPost(long studentId, long postId,String comment) {
        Student student = studentService.getById(studentId);
        Post post = postService.getById(postId);
        Optional<StudentComment> studentComment = findCommentByStudentIdAndPostId(studentId, postId);
        StudentCommentPostResponse existStudentComment = studentCommentPostMapper.toResponse(studentComment.get());
        if (studentComment.isPresent()) {
            existStudentComment.setComment(comment);
            existStudentComment.setPostId(post.getId());
            existStudentComment.setStudentId(student.getId());
            studentCommentRepo.save(studentCommentPostMapper.toEntity(existStudentComment));
        }
            return existStudentComment;
    }


    @Override
    public Optional<StudentComment> findCommentByStudentIdAndPostId(long studentId, long postId) {
        return studentCommentRepo.findCommentByStudentIdAndPostId(studentId,postId);
    }
}
