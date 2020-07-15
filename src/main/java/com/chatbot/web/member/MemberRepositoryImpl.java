package com.chatbot.web.member;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberRepositoryCustom {

    MemberRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public List<Member> findByAddr(String addr) {
        return null;
    }
}
