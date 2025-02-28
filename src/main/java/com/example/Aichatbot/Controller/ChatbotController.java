package com.example.Aichatbot.Controller;


import com.example.Aichatbot.Service.ChatbotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;




@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping("/ask")
    public ResponseEntity<Map<String, String>> chatWithBot(@RequestBody Map<String, String> request) {
        if (request == null || !request.containsKey("message")) {
            return ResponseEntity.badRequest().body(Map.of("error", "Missing 'message' field"));
        }

        String userMessage = request.get("message");
        Map<String, String> response = chatbotService.getChatResponse(userMessage);

        return ResponseEntity.ok(response);
    }
}