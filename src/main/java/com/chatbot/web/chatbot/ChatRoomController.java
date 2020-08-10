package com.chatbot.web.chatbot;

import org.springframework.web.bind.annotation.RestController;

@RestController public class ChatRoomController {
    private final ChatRoomService roomService;

    public ChatRoomController(ChatRoomService roomService) {
        this.roomService = roomService;
    }
}
