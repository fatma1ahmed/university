package com.fatma.university.service;

import com.fatma.university.model.dto.PostRequest;
import com.fatma.university.model.dto.PostResponse;
import com.fatma.university.model.entity.Post;
import com.fatma.university.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface PostService extends CrudService<Post, PostRequest, PostResponse> {
}
