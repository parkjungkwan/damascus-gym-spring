package com.chatbot.web.utils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
public class CsvHandler {
    private String filename = "/mycsv.csv";

    public List<String []> readCsv() {
        System.out.print(">>>>>>>> "+filename);
        List<String[]> data = new ArrayList<String[]>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"), ',', '"', 1);
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
