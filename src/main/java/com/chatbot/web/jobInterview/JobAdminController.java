package com.chatbot.web.jobInterview;

import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.mappers.ModelMapper;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class JobAdminController {
    final ModelMapper modelMapper;

    public JobAdminController(ModelMapper modelMapper) {
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
