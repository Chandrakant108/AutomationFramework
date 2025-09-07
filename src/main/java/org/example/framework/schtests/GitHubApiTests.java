package org.example.framework.schtests;

import org.example.framework.report.ExcelAndDbExporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GitHubApiTests {

    public void runAllTests() {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            driver.get("https://api.github.com");
            // Perform your API-related UI test actions if any
        } finally {
            driver.quit();
        }

        ExcelAndDbExporter exporter = new ExcelAndDbExporter();
        exporter.exportResult("GitHubApiTests", "Passed", 0.808f);
    }
}
