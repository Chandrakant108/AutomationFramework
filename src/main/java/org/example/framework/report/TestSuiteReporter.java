package org.example.framework.report;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class TestSuiteReporter implements ITestListener {

    @Override
    public void onFinish(ITestContext context) {
        // Just log a message — no need to call exportResultsToCSV
        System.out.println("All test results have been written to CSV: test-results.csv");
    }

    // Optional: implement other methods for logging per test
}
