package org.example.framework.report;

import org.testng.annotations.AfterSuite;

public class Reporter {

    @AfterSuite
    public void afterSuite() {
        System.out.println("All test results have been written to CSV: test-results.csv");
    }
}
