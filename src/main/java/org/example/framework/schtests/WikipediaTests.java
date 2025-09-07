package org.example.framework.schtests;

import org.example.framework.report.ExcelAndDbExporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WikipediaTests {

    public void runAllTests() {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            driver.get("https://www.wikipedia.org");
            // Perform your assertions / actions
        } finally {
            driver.quit();
        }

        ExcelAndDbExporter exporter = new ExcelAndDbExporter();
        exporter.exportResult("WikipediaTests", "Passed", 0.714f);
    }
}
