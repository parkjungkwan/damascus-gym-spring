package com.chatbot.web.admin;

import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.mappers.ModelMapper;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    final ModelMapper modelMapper;

    public AdminController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping("/login")
    public Manager login(@RequestBody Manager manager){
        try {
            // return repo.findByManagerIdAndPwd(rdto.getManagerId(), rdto.getPwd());
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
