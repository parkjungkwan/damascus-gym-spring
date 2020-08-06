package com.chatbot.web.progress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/progresses")
public class ProgressController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
