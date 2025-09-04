package org.example.tests;

import org.example.framework.report.CSVExporter;
import org.example.framework.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class WikipediaTests {

    WebDriver driver;
    long start;

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        start = System.currentTimeMillis();
    }

    @Test
    public void testWikipediaHomePageTitle() {
        driver.get("https://www.wikipedia.org");

        boolean result = driver.getTitle() != null && driver.getTitle().contains("Wikipedia");
        float execTime = (System.currentTimeMillis() - start) / 1000F;

        // Generate a unique ID for each test run (can use timestamp)
        String testId = String.valueOf(System.currentTimeMillis());

        CSVExporter.exportResult(String.valueOf(System.currentTimeMillis()),
                "Wikipedia Home Page Test", "wikipedia.org",
                result ? "Passed" : "Failed", execTime);

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
