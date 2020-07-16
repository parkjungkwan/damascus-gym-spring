package com.chatbot.web.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
interface MemberRepository extends JpaRepository<Member, Long>, MemberService {}

interface MemberService {
    public List<Member> findByAddr(String addr);

}

public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberService{

    MemberRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public List<Member> findByAddr(String addr) {
        return null;
    }
}
