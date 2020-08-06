package com.chatbot.web.passenger;

import com.chatbot.web.utils.CsvHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    @Autowired PassengerService passengerService;
    @GetMapping("/csv")
    public void csvRead(){
        passengerService.readCsv();
    }
}
