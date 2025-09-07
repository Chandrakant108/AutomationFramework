package org.example.framework.report;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelExporter {

    private static final String FILE_PATH = "TestResults.xlsx";
    private static final String SHEET_NAME = "Results";

    public static void saveToExcel(String testName, String status, float execTime, String timestamp) {
        try {
            Workbook workbook;
            Sheet sheet;

            File file = new File(FILE_PATH);
            if (file.exists()) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = new XSSFWorkbook(fis);
                    sheet = workbook.getSheet(SHEET_NAME);
                    if (sheet == null) {
                        sheet = workbook.createSheet(SHEET_NAME);
                        createHeader(sheet);
                    }
                }
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet(SHEET_NAME);
                createHeader(sheet);
            }

            int lastRowNum = sheet.getLastRowNum();
            Row row = sheet.createRow(lastRowNum + 1);

            row.createCell(0).setCellValue(testName);
            row.createCell(1).setCellValue(status);
            row.createCell(2).setCellValue(execTime);
            row.createCell(3).setCellValue(timestamp);

            for (int i = 0; i <= 3; i++) sheet.autoSizeColumn(i);

            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
            }
            workbook.close();

            System.out.println("Test result exported to Excel: " + testName + " | " + status + " | " + execTime + "s | " + timestamp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createHeader(Sheet sheet) {
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Test Name");
        header.createCell(1).setCellValue("Status");
        header.createCell(2).setCellValue("Execution Time (s)");
        header.createCell(3).setCellValue("Timestamp");
    }
}
