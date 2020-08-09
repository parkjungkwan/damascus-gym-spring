package com.chatbot.web.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperUtil {
    @Bean
    public ModelMapper ModelMapper() {
        return new ModelMapper();
    }
}
