package org.example.framework.report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExcelAndDbExporter {

    // Export result to Excel and DB safely
    public static void exportResult(String testName, String status, float execTime) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 1️⃣ Excel export (synchronized to prevent concurrent writes)
        synchronized (ExcelExporter.class) {
            ExcelExporter.saveToExcel(testName, status, execTime, timestamp);
        }

        // 2️⃣ DB export (can be parallel)
        DbExporter.saveToDB(testName, status, execTime, timestamp);
    }
}
