package com.chatbot.web.progress;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProgressControllerTest {

    @Autowired
    ProgressController progressController;

    @Test
    void helloWorld() {
        assertThat(progressController.helloWorld()).isEqualTo("TDD Success !! ");
    }
}