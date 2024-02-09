package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.PostMapper;
import com.fatma.university.model.dto.PostRequest;
import com.fatma.university.model.dto.PostResponse;
import com.fatma.university.model.entity.Post;
import com.fatma.university.reposity.PostRepo;
import com.fatma.university.service.PostCategorySourceService;
import com.fatma.university.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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
        long categoryId=postRequest.getCategoryId();
        long sourceId=postRequest.getSourceId();
        Post post=postMapper.toEntity(postRequest);
        if(post.getImagePath()!=null &&!post.getImagePath().isEmpty() && post.getImagePath()!="string") {
            byte[] imageBytes = imageService.decodeBase64(post.getImagePath());
            post.setImagePath(imageService.saveImage(imageBytes));
        }
        postCategorySourceService.assignPostToCategoryAndSource(post,categoryId,sourceId);
        postRepo.save(post);
        PostResponse postResponse=postMapper.fromEntityToResponseDto(post);
        postResponse.setId(post.getId());
        postResponse.setCategoryName(post.getCategory().getName());
        postResponse.setSourceName(post.getSource().getFullName());

        return postResponse;
    }

    @Override
    public PostResponse update(PostRequest postRequest, long id) throws IOException {
       Post exisitPost=getById(id);
        long categoryId=postRequest.getCategoryId();
        long sourceId=postRequest.getSourceId();
        Post post=postMapper.toEntity(postRequest);
        postCategorySourceService.updatePost(post,categoryId,sourceId);
        post.setId(id);
        post.setCreateDate(exisitPost.getCreateDate());
        postRepo.save(post);
        PostResponse postResponse=postMapper.fromEntityToResponseDto(post);
        postResponse.setCategoryName(post.getCategory().getName());
        postResponse.setSourceName(post.getSource().getFullName());
        postResponse.setId(post.getId());
        postResponse.setCreateDate(exisitPost.getCreateDate());
        postResponse.setUpdateDate(exisitPost.getUpdateDate());
        return postResponse;
    }

    @Override
    public Post getById(long id) {
        Post post=postRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this Post with " + id + " not found")
        );
        return post;
    }

    @Override
    public List<PostResponse> getAll() {
        return postRepo.findAll().stream()
                .map(post -> {PostResponse postResponse=postMapper.fromEntityToResponseDto(post);
                    postResponse.setSourceName(post.getSource().getFullName());
                    postResponse.setCategoryName(post.getCategory().getName());
                    postResponse.setId(post.getId());
                    return postResponse;
                })
                .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getById(id);
        postRepo.deleteById(id);
        return new ResponseEntity<>("Post with " + id  +" is deleted", HttpStatus.ACCEPTED);
    }
}
