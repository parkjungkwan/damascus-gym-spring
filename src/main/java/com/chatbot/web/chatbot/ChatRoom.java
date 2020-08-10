package com.chatbot.web.chatbot;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity public class ChatRoom {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
