package com.fatma.university.AI;

import org.springframework.stereotype.Service;

@Service
public interface ChatBotService {

    String getResponseForQuestion(String question);
}
