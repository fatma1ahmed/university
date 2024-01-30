package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.EventMapper;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Source;
import com.fatma.university.reposity.EventRepo;
import com.fatma.university.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private ImageServiceImpl imageService;
    @Override
    public EventResponse add(Event event) throws IOException {
        byte[] imageBytes=imageService.decodeBase64(event.getImagePath());
        event.setImagePath(imageService.saveImage(imageBytes));
        Event savedEvent=eventRepo.save(event);
        return eventMapper.fromEntityToResponseDto(savedEvent);
    }

    @Override
    public EventResponse update(Event event, long id) throws IOException {
        checkThisIsFoundORThrowException(id);
        Event updatedEvent=eventRepo.save(event);
        return eventMapper.fromEntityToResponseDto(updatedEvent);
    }

    @Override
    public Event getById(long id) {
        Event event=eventRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this Event with " + id + " not found")
        );
        return event;
    }

    @Override
    public List<EventResponse> getAll() {
       return eventRepo.findAll().stream()
               .map(event ->{EventResponse eventResponse=eventMapper.fromEntityToResponseDto(event);
                   Category category=event.getCategory();
                   Source source=event.getSource();
                   eventResponse.setCategoryName(category.getCategoryName());
                   eventResponse.setSourceName(source.getFullName());
                   return eventResponse;

               })

               .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        checkThisIsFoundORThrowException(id);
        eventRepo.deleteById(id);
        return new ResponseEntity<>("Event with " + id  +" is deleted",HttpStatus.ACCEPTED);
    }

    @Override
    public void checkThisIsFoundORThrowException(long id) {
        getById(id);

    }
}
