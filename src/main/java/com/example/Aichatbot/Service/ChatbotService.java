package com.example.Aichatbot.Service;

import com.example.Aichatbot.Entity.ChatMessage;
import com.example.Aichatbot.Repository.ChatbotRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;




@Service
public class ChatbotService {

    private final ChatbotRepository chatbotRepository;

    public ChatbotService(ChatbotRepository chatbotRepository) {
        this.chatbotRepository = chatbotRepository;
    }

    public Map<String, String> getChatResponse(String userMessage) {
        // Convert message to lowercase for case-insensitive matching
        String message = userMessage.toLowerCase();

        // Predefined responses
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("hello", "Hai, how can I help you?");
        responseMap.put("hi", "Hello! How can I assist you?");
        responseMap.put("how are you", "I'm just a bot, but I'm here to help!");
        responseMap.put("who are you", "I'm your AI chatbot, ready to assist you.");
        responseMap.put("bye", "Goodbye! Have a great day.");
        responseMap.put("what is your name", "I'm ChatBot, your virtual assistant.");
        responseMap.put("thank you", "You're welcome! Feel free to ask anything.");

        // Get response or default fallback
        String botResponse = responseMap.getOrDefault(message, "Sorry, I don't understand that.");

        // Save to database
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserMessage(userMessage);
        chatMessage.setBotResponse(botResponse);
        chatMessage.setTimestamp(LocalDateTime.now());

        chatbotRepository.save(chatMessage);

        return Map.of("response", botResponse);
    }
}
