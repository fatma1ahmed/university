package com.fatma.university.service;

import com.fatma.university.model.entity.Event;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface EventCategoryService {
    public void assignEventToCategory(Event event,long categoryId) ;




}
