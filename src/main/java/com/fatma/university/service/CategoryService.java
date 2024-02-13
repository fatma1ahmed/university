package com.fatma.university.service;

import com.fatma.university.model.dto.CategoryRequest;
import com.fatma.university.model.dto.CategoryResponse;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Video;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService extends CrudService<Category, CategoryRequest, CategoryResponse> {
    public List<Event> getAllEventsByCategoryId(long categoryId);
    public List<Post> getAllPostsByCategoryId(long categoryId);
    public List<Video> getAllVideosByCategoryId(long categoryId);

}
