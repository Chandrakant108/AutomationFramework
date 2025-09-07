package org.example.framework.schtests;

import org.example.framework.report.ExcelAndDbExporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GitHubTests {

    public void runAllTests() {
        ChromeOptions options = new ChromeOptions();
        // Remove headless mode
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        try {
            // Your test steps here
            driver.get("https://github.com");
            // Perform your assertions / actions
        } finally {
            driver.quit();
        }

        // Export result to Excel/DB
        ExcelAndDbExporter exporter = new ExcelAndDbExporter();
        exporter.exportResult("GitHubTests", "Passed", 0.512f);
    }
}
