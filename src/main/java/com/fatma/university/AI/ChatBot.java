package com.fatma.university.AI;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.parameters.P;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ChatBot {

    private List<String> patterns;
    private List<String> responses;

}
