package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentLikePostMapper;
import com.fatma.university.model.dto.StudentLikePostResponse;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Student;
import com.fatma.university.model.entity.StudentLike;
import com.fatma.university.reposity.StudentLikeRepo;
import com.fatma.university.service.PostService;
import com.fatma.university.service.StudentLikePostService;
import com.fatma.university.service.StudentService;
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
    private StudentLikePostMapper studentLikePostMapper;
    @Override
    public StudentLikePostResponse putLikeToPost(long studentId, long postId) {
        Student student = studentService.getById(studentId);
        Post post = postService.getById(postId);
        Optional<StudentLike> studentLike=findLikeByStudentIdAndPostId(studentId,postId);
        if(studentLike.isPresent()) {
            return updateLikeToPost(studentId, postId);
        }
      else  {
            StudentLikePostResponse createLike=new StudentLikePostResponse();
            createLike.setLike(true);
            createLike.setPostId(post.getId());
            createLike.setStudentId(student.getId());
         StudentLike savedLike=studentLikeRepo.save(studentLikePostMapper.toEntity(createLike));
         createLike.setId(savedLike.getId());
            return createLike;
        }
    }

    @Override
    public StudentLikePostResponse updateLikeToPost(long studentId, long postId) {
        Student student = studentService.getById(studentId);
        Post post = postService.getById(postId);
        Optional<StudentLike> studentLike = findLikeByStudentIdAndPostId(studentId, postId);
        StudentLikePostResponse existLike = studentLikePostMapper.toResponse(studentLike.get());
        if (studentLike.isPresent()) {
            boolean currentLike=existLike.isLike();
            existLike.setLike(!currentLike);
            existLike.setPostId(post.getId());
            existLike.setStudentId(student.getId());
            studentLikeRepo.save(studentLikePostMapper.toEntity(existLike));
        }
        return existLike;
    }
    @Override
    public Optional<StudentLike> findLikeByStudentIdAndPostId(long studentId, long postId) {
        return studentLikeRepo.findLikeByStudentIdAndPostId(studentId,postId);
    }
}
