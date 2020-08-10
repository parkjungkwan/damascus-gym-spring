package com.chatbot.web.employment;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmploymentService {

    public Optional<WorkMember> findById(String id) {
        return Optional.empty();
    }

    public Iterable<WorkMember> findAll() {
        return null;
    }

    public int count() {
        return 0;
    }

    public void delete(String id) {

    }

    public boolean exists(String id) {
        return false;
    }
}
