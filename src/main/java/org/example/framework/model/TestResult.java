package org.example.framework.model;

import java.time.LocalDateTime;

public class TestResult {
    private String testName;
    private String url;
    private String status;
    private float executionTime;
    private LocalDateTime timestamp;

    public TestResult(String testName, String url, String status, float executionTime, LocalDateTime timestamp) {
        this.testName = testName;
        this.url = url;
        this.status = status;
        this.executionTime = executionTime;
        this.timestamp = timestamp;
    }

    // Getters
    public String getTestName() { return testName; }
    public String getUrl() { return url; }
    public String getStatus() { return status; }
    public float getExecutionTime() { return executionTime; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
