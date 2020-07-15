package com.chatbot.web.member;

import java.util.List;

public interface MemberRepositoryCustom {
    public List<Member> findByAddr(String addr);
}
