package com.chatbot.web.chatbot;

import org.springframework.web.bind.annotation.RestController;

@RestController public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
}
