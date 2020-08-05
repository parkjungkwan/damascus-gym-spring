package com.chatbot.web.progress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgressController {
    @ResponseBody @GetMapping("/hello")
    public String process(){
        return "Hello Controller";
    }
}
