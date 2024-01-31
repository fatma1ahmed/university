package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.EventMapper;
import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Source;
import com.fatma.university.reposity.EventRepo;
import com.fatma.university.service.EventCategorySourceService;
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
    private EventCategorySourceService eventCategorySourceService;
    @Override
    public EventResponse add(EventRequest eventRequest) throws IOException {
        long categoryId=eventRequest.getCategoryId();
        long sourceId=eventRequest.getSourceId();
        Event event=eventMapper.toEntity(eventRequest);
        if(event.getImagePath()!=null &&!event.getImagePath().isEmpty() && event.getImagePath()!="string") {
            byte[] imageBytes = imageService.decodeBase64(event.getImagePath());
            event.setImagePath(imageService.saveImage(imageBytes));
        }
        eventCategorySourceService.assignEventToCategoryAndSource(event,categoryId,sourceId);
        EventResponse eventResponse=new EventResponse();
        eventResponse.setCategoryName(event.getCategory().getCategoryName());
        eventResponse.setSourceName(event.getSource().getFullName());
        eventResponse.setAddress(event.getAddress());
        eventResponse.setPlace(event.getPlace());
        eventResponse.setDate(event.getDate());
        eventResponse.setTime(event.getTime());
        eventResponse.setIsBroadcast(event.getIsBroadcast());

       eventRepo.save(event);
        return eventResponse;
    }

    @Override
    public EventResponse update(EventRequest eventRequest, long id) throws IOException {
        checkThisIsFoundORThrowException(id);
        long categoryId=eventRequest.getCategoryId();
        long sourceId=eventRequest.getSourceId();
        Event event=eventMapper.toEntity(eventRequest);
        eventCategorySourceService.updateEvent(event,categoryId,sourceId);
        event.setId(id);
        eventRepo.save(event);
        EventResponse eventResponse=new EventResponse();
        eventResponse.setCategoryName(event.getCategory().getCategoryName());
        eventResponse.setSourceName(event.getSource().getFullName());
        eventResponse.setAddress(event.getAddress());
        eventResponse.setPlace(event.getPlace());
        eventResponse.setDate(event.getDate());
        eventResponse.setTime(event.getTime());
        eventResponse.setIsBroadcast(event.getIsBroadcast());


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
                   eventResponse.setCategoryName(event.getCategory().getCategoryName());
                   eventResponse.setSourceName(event.getSource().getFullName());
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
