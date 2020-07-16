package com.chatbot.web.member;

import com.google.gson.JsonObject;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class MemberController {
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager manager;

    @GetMapping("/all")
    public ResponseEntity findAllOrderByJoinDate(){
        return ResponseEntity
                .ok(memberRepository
                        .findAllOrderByJoinDate());
    }
    @GetMapping("/")
    public String test(){

        JsonObject obj =new JsonObject();

        obj.addProperty("title", "테스트3");
        obj.addProperty("content", "테스트3 내용");

        JsonObject data = new JsonObject();

        data.addProperty("time", "12:00");

        obj.add("data", data);

        return obj.toString();
    }
}
