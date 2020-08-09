package com.chatbot.web.passenger;

import com.chatbot.web.employment.Passenger;
import com.chatbot.web.utils.Box;
import com.chatbot.web.utils.GenericService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
// https://bezkoder.com/spring-boot-upload-csv-file/
import java.io.*;
import java.util.List;
import java.util.Optional;

interface PassengerService extends GenericService<Passenger> {
    // QueryMethod 구현
    public Box<List<Passenger>> findBySurvived(int survived);
    public void readCsv();
    // Anonoymous Named Query 구현

    // Named Query 구현
}
@Service
public class PassengerServiceImpl implements PassengerService{
    private final PassengerRepository repository;
    private final Box<List<Passenger>> passengers;

    public PassengerServiceImpl(PassengerRepository repository,
                                Box<List<Passenger>> passengers) {
        this.repository = repository;
        this.passengers = passengers;
    }

    @Override public Optional<Passenger> findById(String id) {
        return repository.findById(Integer.parseInt(id));
    }
    @Override public Iterable<Passenger> findAll(){
        return repository.findAll();
    }
    @Override public int count() {
        return (int)repository.count();
    }
    @Override
    public void delete(String id) {
        repository.delete(findById(id).orElse(new Passenger()));
    }
    @Override
    public boolean exists(String passengerId) {
        return repository.existsById(Integer.parseInt(passengerId));
    }

    @Override
    public Box<List<Passenger>> findBySurvived(int survived){
        passengers.put((survived == 1)? "Survivors":"Deads",repository.findBySurvived(survived));
        return passengers;
    }

    @Override
    public void readCsv(){
        InputStream is = getClass().getResourceAsStream("/static/train.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for(CSVRecord csvRecord : csvRecords){
                // PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,
                // Parch,Ticket,Fare,Cabin,Embarked
                repository.save(new Passenger(
                        Integer.parseInt(csvRecord.get(1)),
                        Integer.parseInt(csvRecord.get(2)),
                        csvRecord.get(3),
                        csvRecord.get(4),
                        csvRecord.get(5),
                        csvRecord.get(6),
                        csvRecord.get(7),
                        csvRecord.get(8),
                        csvRecord.get(9),
                        csvRecord.get(10),
                        csvRecord.get(11)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}