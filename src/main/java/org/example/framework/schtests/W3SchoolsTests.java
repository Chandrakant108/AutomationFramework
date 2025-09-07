package org.example.framework.schtests;

import org.example.framework.report.ExcelAndDbExporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class W3SchoolsTests {

    public void runAllTests() {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            driver.get("https://www.w3schools.com");
            // Perform your assertions / actions
        } finally {
            driver.quit();
        }

        ExcelAndDbExporter exporter = new ExcelAndDbExporter();
        exporter.exportResult("W3SchoolsTests", "Passed", 0.606f);
    }
}
