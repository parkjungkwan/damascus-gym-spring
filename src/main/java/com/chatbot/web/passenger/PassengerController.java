package com.chatbot.web.passenger;

import com.chatbot.web.utils.Box;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController @AllArgsConstructor
@RequestMapping("/passengers")
public class PassengerController {
    private PassengerService passengerService;

    @GetMapping("/csv")
    public void csvRead(){ passengerService.readCsv(); }
    @GetMapping("/survived/{survived}")
    public Box<List<Passenger>> findBySurvived(@PathVariable int survived){
        return passengerService.findBySurvived(survived);
    }
    @GetMapping("/passengerNumber/{id}")
    public Optional<Passenger> findById(@PathVariable String id){
        return passengerService.findById(id);
    }
}