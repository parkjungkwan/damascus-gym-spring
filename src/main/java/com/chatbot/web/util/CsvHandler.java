package com.chatbot.web.util;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.stereotype.Service;

@Service
public class CsvHandler {
    public List<String []> readCsv() {
        InputStream in = getClass().getResourceAsStream("/static/train.csv");
        List<String[]> data = new ArrayList<String[]>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(in, "UTF-8"), ',', '"', 1);
            String[] s;
            while ((s = reader.readNext()) != null) {
                data.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
