package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.PostMapper;
import com.fatma.university.model.dto.PostRequest;
import com.fatma.university.model.dto.PostResponse;
import com.fatma.university.model.entity.Post;
import com.fatma.university.repository.PostRepo;
import com.fatma.university.service.PostCategorySourceService;
import com.fatma.university.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private ImageServiceImpl imageService;
    @Autowired
    private PostCategorySourceService postCategorySourceService;

    @Override
    public PostResponse add(PostRequest postRequest) throws IOException {
        long categoryId = postRequest.getCategoryId();
        long sourceId = postRequest.getSourceId();
        Post post = postMapper.toEntity(postRequest);
//        post.setImagePath(imageService.saveImageToBase64(post.getImagePath()));
        postCategorySourceService.assignPostToCategoryAndSource(post, categoryId, sourceId);


        return postMapper.toResponse(postRepo.save(post));
    }

    @Override
    public PostResponse update(PostRequest postRequest, long id) throws IOException {
        Post exisitPost = getById(id);
        long categoryId = postRequest.getCategoryId();
        long sourceId = postRequest.getSourceId();
        Post post = postMapper.toEntity(postRequest);
        postCategorySourceService.updatePost(post, categoryId, sourceId);
        post.setId(id);
        post.setCreateDate(exisitPost.getCreateDate());
//        post.setImagePath(imageService.saveImageToBase64(post.getImagePath()));
        return postMapper.toResponse(postRepo.save(post));
    }

    @Override
    public Post getById(long id) {
        return postRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this Post with " + id + " not found")
        );
    }

    @Override
    public PostResponse getEntityById(long id) {
        Post post = postRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this Post with " + id + " not found")
        );
        return postMapper.toResponse(post);
    }

    @Override
    public List<PostResponse> getAll() {
        return postRepo.findAll().stream()
                .map(postMapper::toResponse)
                .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getById(id);
        postRepo.deleteById(id);
        return new ResponseEntity<>("Post with " + id + " is deleted", HttpStatus.ACCEPTED);
    }

    @Override
    public List<PostResponse> getAllForDepartment(long departmentId) {
        return postRepo.findAllBySourceDepartmentId(departmentId).stream().map(postMapper::toResponse).collect(Collectors.toList());
    }
}
