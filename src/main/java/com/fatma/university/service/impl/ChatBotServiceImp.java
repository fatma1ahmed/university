//package com.fatma.university.service.impl;
//
//
//import com.fatma.university.mapper.ChatBotMapper;
//import com.fatma.university.model.dto.ChatBotRequest;
//import com.fatma.university.model.dto.ChatBotResponse;
//import com.fatma.university.model.entity.ChatBot;
//import com.fatma.university.repository.ChatBotRepository;
//import com.fatma.university.service.ChatBotService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@Service
//@RequiredArgsConstructor
//public class ChatBotServiceImp implements ChatBotService {
//
//    private final ChatBotRepository chatBotRepository;
//    private final ChatBotMapper chatBotMapper;
//
//    @Override
//    public ChatBotResponse add(ChatBotRequest chatBotRequest) throws IOException {
//        return chatBotMapper.toResponse(chatBotRepository.save(chatBotMapper.toEntity(chatBotRequest)));
//    }
//
//    @Override
//    public ChatBotResponse update(ChatBotRequest chatBotRequest, long id) throws IOException {
//        ChatBot chatBot = getById(id);
//        chatBot = chatBotMapper.toEntity(chatBotRequest);
//        chatBot.setId(id);
//        return chatBotMapper.toResponse(chatBotRepository.save(chatBot));
//    }
//
//    @Override
//    public ChatBot getById(long id) {
//        return chatBotRepository.findById(id)
//                .orElseThrow(
//                        () -> new NoSuchElementException("No Questions Exist with this id")
//                );
//    }
//
//    @Override
//    public ChatBotResponse getEntityById(long id) {
//        return chatBotMapper.toResponse(getById(id));
//    }
//
//    @Override
//    public List<ChatBotResponse> getAll() {
//        return chatBotRepository.findAll()
//                .stream()
//                .map(chatBotMapper::toResponse)
//                .toList();
//    }
//
//    @Override
//    public ResponseEntity<?> deleteById(long id) {
//        getById(id);
//        deleteById(id);
//        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
//    }
//}
