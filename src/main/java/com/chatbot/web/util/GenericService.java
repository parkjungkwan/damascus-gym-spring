package com.chatbot.web.util;

import java.util.Optional;

public interface GenericService<T> {
    // 공통 인터페이스 기능
    public Optional<T> findById(String id);
    public Iterable<T> findAll();
    public int count();
    public void delete(String id);
    public boolean exists(String id) ;
}
