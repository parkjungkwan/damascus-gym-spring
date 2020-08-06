package com.chatbot.web.passenger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// https://bezkoder.com/spring-boot-upload-csv-file/
import java.io.*;

interface PassengerService{
    public void handleCsv();
}
@Service
public class PassengerServiceImpl implements PassengerService{
    @Autowired PassengerRepository passengerRepository;


    @Override
    public void handleCsv(){
        InputStream is = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for(CSVRecord csvRecord : csvRecords){
                passengerRepository.save(new Passenger(Integer.parseInt(csvRecord.get("passengerNumber")),
                        Integer.parseInt(csvRecord.get("survived")),
                        Integer.parseInt(csvRecord.get("pclass")),
                        csvRecord.get("name"),
                        csvRecord.get("sex"),
                        Integer.parseInt("age"),
                        Integer.parseInt("sib_sp"),
                        Integer.parseInt("parch"),
                        csvRecord.get("ticket"),
                        csvRecord.get("fare"),
                        csvRecord.get("cabin"),
                        csvRecord.get("embarked")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//
    }
}
