package com.chatbot.web.employment;

import com.chatbot.web.utils.GenericService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface MemberService extends GenericService<Member> {


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
