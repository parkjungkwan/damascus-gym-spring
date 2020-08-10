package com.chatbot.web.chatbot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long>, IChatRoomRepository {
}
