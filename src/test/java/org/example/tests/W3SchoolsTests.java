package org.example.tests;

import org.example.framework.report.CSVExporter;
import org.example.framework.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.LocalDateTime;

public class W3SchoolsTests {

    WebDriver driver;
    long start;

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        start = System.currentTimeMillis();
    }

    @Test
    public void testW3SchoolsHomePageTitle() {
        driver.get("https://www.w3schools.com");

        boolean result = driver.getTitle() != null && driver.getTitle().contains("W3Schools");
        float execTime = (System.currentTimeMillis() - start) / 1000F;

        CSVExporter.exportResult(String.valueOf(System.currentTimeMillis()),
                "W3Schools Home Page Test", "w3schools.com",
                result ? "Passed" : "Failed", execTime);

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
