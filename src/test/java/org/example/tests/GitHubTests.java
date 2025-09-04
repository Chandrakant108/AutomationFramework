package org.example.tests;

import org.example.framework.report.CSVExporter;
import org.example.framework.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.LocalDateTime;

public class GitHubTests {

    WebDriver driver;
    long start;

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        start = System.currentTimeMillis();
    }

    @Test
    public void testGitHubHomePageTitle() {
        driver.get("https://github.com");

        boolean result = driver.getTitle() != null && driver.getTitle().contains("GitHub");
        float execTime = (System.currentTimeMillis() - start) / 1000F;

        CSVExporter.exportResult(String.valueOf(System.currentTimeMillis()),
                "GitHub Home Page Test", "github.com",
                result ? "Passed" : "Failed", execTime);

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
