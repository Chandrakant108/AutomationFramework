package org.example.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumManagerTests {

    public static void main(String[] args) {
        runTest("https://github.com/");
        runTest("https://www.w3schools.com/");
        runTest("https://www.wikipedia.org/");
        runTest("https://api.github.com/");
    }

    /**
     * Generic method to run a test for any URL.
     * Selenium Manager automatically resolves the correct ChromeDriver version.
     */
    public static void runTest(String url) {
        System.out.println("Running test for: " + url);

        WebDriver driver = new ChromeDriver(); // Selenium Manager auto-handles driver
        try {
            driver.get(url);
            System.out.println("Page title: " + driver.getTitle());
        } catch (Exception e) {
            System.out.println("Error during test: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}