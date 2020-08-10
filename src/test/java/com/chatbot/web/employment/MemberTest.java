package com.chatbot.web.employment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void getName() {
        final WorkMember member = WorkMember.builder().name("James").build();
        final String name = member.getName();
        assertEquals("James", name);
    }
}