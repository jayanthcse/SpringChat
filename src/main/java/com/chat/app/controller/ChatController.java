package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        // Set default message type if not specified
        if (message.getType() == null) {
            message.setType(ChatMessage.MessageType.CHAT);
        }
        return message;
    }

    @MessageMapping("/videoCall")
    @SendTo("/topic/messages")
    public ChatMessage handleVideoCall(ChatMessage message) {
        // Handle video call signaling messages
        return message;
    }

    @GetMapping("/chat")
    @PreAuthorize("hasRole('USER')")
    public String chat() {
        return "chat";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/api/auth/login";
    }
}
