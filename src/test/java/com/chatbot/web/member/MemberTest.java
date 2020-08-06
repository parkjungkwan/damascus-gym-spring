package com.chatbot.web.member;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void getName() {
        final Member member = Member.builder().name("James").build();
        final String name = member.getName();
        assertEquals("James", name);
    }
}