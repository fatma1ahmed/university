package com.fatma.university.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatBotRequest {
    @JsonProperty("chat_bot_question")
    private String question;
    @JsonProperty("chat_bot_answer")
    private String answer;

}
