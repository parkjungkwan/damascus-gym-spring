package com.chatbot.web.member;

import com.chatbot.web.utils.JpaService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface MemberService extends JpaService<Member> {


}
@Service
public class MemberServiceImpl implements MemberService{

    @Override
    public Optional<Member> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Member> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public boolean exists(String id) {
        return false;
    }
}
