package com.example.Aichatbot.Repository;


import com.example.Aichatbot.Entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // ✅ Ensure this annotation is present
public interface ChatbotRepository extends JpaRepository<ChatMessage, Long> {
}