package com.fatma.university.reposity;

import com.fatma.university.model.entity.ChatBot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatBotRepository extends JpaRepository<ChatBot , Long> {
}
