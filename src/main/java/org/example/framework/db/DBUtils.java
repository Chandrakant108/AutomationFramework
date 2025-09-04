package org.example.framework.db;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBUtils {

    private static final String CSV_FILE = "test-results.csv";

    // Thread-safe CSV writing
    public static synchronized void saveResult(String testName, String url, String status, float execTime) {
        try (FileWriter fw = new FileWriter(CSV_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {

            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            pw.printf("%s,%s,%s,%.3f,%s%n", testName, url, status, execTime, timestamp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
