package com.fatma.university.mapper;


import com.fatma.university.model.dto.ChatBotRequest;
import com.fatma.university.model.dto.ChatBotResponse;
import com.fatma.university.model.entity.ChatBot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatBotMapper {


    ChatBot toEntity(ChatBotRequest chatBotRequest);

    ChatBotResponse toResponse(ChatBot chatBot);
}
