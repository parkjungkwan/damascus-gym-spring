package com.chatbot.web.progress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgressController {

    @GetMapping("/")
    public String helloWorld(){
        return "TDD Success !! ";
    }
}
