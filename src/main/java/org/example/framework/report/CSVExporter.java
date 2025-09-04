package org.example.framework.report;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class CSVExporter {

    private static final String FILE_PATH = "test-results.csv";

    public static synchronized void exportResult(String id, String testName, String url, String status, float execTime) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH, true))) { // append = true
            String[] row = {id, testName, url, status, String.valueOf(execTime), LocalDateTime.now().toString()};
            writer.writeNext(row);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
