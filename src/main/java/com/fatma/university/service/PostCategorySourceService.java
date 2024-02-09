package com.fatma.university.service;

import com.fatma.university.model.entity.Post;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface PostCategorySourceService {
    public void assignPostToCategoryAndSource(Post post, long categoryId, long sourceId) throws IOException;

    public void updatePost(Post post,long CategoryId,long sourceId) throws IOException;
}
