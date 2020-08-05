package com.chatbot.web.member;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void getName() {
        final Member member = Member.builder().name("홍길동").build();
        final String name = member.getName();
        assertEquals("홍길동", name);
    }
}