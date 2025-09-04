package org.example.tests;

import org.example.framework.report.CSVExporter;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.*;

public class GitHubApiTests {

    @Test
    public void testGitHubAPIStatus() {
        long start = System.currentTimeMillis();

        // Example API call
        int statusCode = given()
                .baseUri("https://api.github.com")
                .when()
                .get("/repos/octocat/Hello-World")
                .then()
                .extract()
                .statusCode();

        float execTime = (System.currentTimeMillis() - start) / 1000F;
        boolean result = statusCode == 200;

        // Add result to CSVExporter
        CSVExporter.exportResult(String.valueOf(System.currentTimeMillis()),
                "GitHub API Test", "api.github.com",
                result ? "Passed" : "Failed", execTime);


    }
}
