package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.EventMapper;
import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Event;
import com.fatma.university.reposity.EventRepo;
import com.fatma.university.service.EventCategoryService;
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
    @Autowired
    private EventCategoryService eventCategoryService;
    @Override
    public EventResponse add(EventRequest eventRequest) throws IOException {
        long categoryId=eventRequest.getCategoryId();
        Event event=eventMapper.toEntity(eventRequest);
        if(event.getImagePath()!=null &&!event.getImagePath().isEmpty() && event.getImagePath()!="string") {
            byte[] imageBytes = imageService.decodeBase64(event.getImagePath());
            event.setImagePath(imageService.saveImage(imageBytes));
        }
        eventCategoryService.assignEventToCategory(event,categoryId);
        eventRepo.save(event);
        EventResponse eventResponse=eventMapper.fromEntityToResponseDto(event);
        eventResponse.setCategoryName(event.getCategory().getName());
        eventResponse.setId(event.getId());

        return eventResponse;
    }

    @Override
    public EventResponse update(EventRequest eventRequest, long id) throws IOException {
        getById(id);
        long categoryId=eventRequest.getCategoryId();
        Event event=eventMapper.toEntity(eventRequest);
        eventCategoryService.updateEvent(event,categoryId);
        event.setId(id);
        eventRepo.save(event);
        EventResponse eventResponse=eventMapper.fromEntityToResponseDto(event);
        eventResponse.setCategoryName(event.getCategory().getName());
        eventResponse.setId(event.getId());
        return eventResponse;
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
                   eventResponse.setCategoryName(event.getCategory().getName());
                   return eventResponse;

               })

               .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getById(id);
        eventRepo.deleteById(id);
        return new ResponseEntity<>("Event with " + id  +" is deleted",HttpStatus.ACCEPTED);
    }


}
