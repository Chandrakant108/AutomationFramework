# Automation Framework

This project is a Java-based automation framework using **Selenium**, **TestNG**, and **REST Assured** for testing web applications and APIs. It also includes a **CSV reporting mechanism** to log test results.

---

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Running Tests](#running-tests)
- [CSV Reporting](#csv-reporting)
- [Notes](#notes)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- Automated **UI tests** using Selenium WebDriver.
- Automated **API tests** using REST Assured.
- Generates a **CSV report** for all test results.
- Supports **multiple browsers** for UI tests (Chrome, Firefox, Edge, etc.).
- Maintains historical results in the CSV file without overwriting previous data.

---

## Technologies

- **Java 23**
- **TestNG 7.10.2**
- **Selenium 4.35.0**
- **REST Assured 5.5.0**
- **Apache Commons CSV 1.10.0**
- **OpenCSV 5.9**
- **SLF4J 1.7.36**
- **Maven** for dependency management

---

## Project Structure



AutomationFramework/
│
├─ src/main/java/org/example/framework/report/
│ ├─ CSVExporter.java # Handles CSV export
│ ├─ Reporter.java # Generates CSV after test suite
│ └─ TestSuiteReporter.java # TestNG listener for CSV generation
│
├─ src/test/java/org/example/tests/
│ ├─ GitHubApiTests.java # Sample API test
│ └─ OtherUITests.java # Sample UI tests
│
├─ pom.xml # Maven configuration
└─ testng.xml # TestNG suite configuration



---

## Setup

1. **Clone the repository:**
   ```bash
   git clone <your-repo-url>

2. Open the project in IntelliJ IDEA or Eclipse.

3. Ensure Maven is installed and all dependencies are resolved.

4. Install browser drivers if running UI tests (ChromeDriver, GeckoDriver, etc.).

5. Update test data if needed.


Running Tests
Using Maven:
mvn clean test

Using TestNG Suite:

Right-click on testng.xml → Run as → TestNG Suite.

Test Reports:

A CSV report is automatically generated after the test suite runs.

Historical test results are appended, so previous test data is preserved.


CSV Reporting

File: test-results.csv

Columns:

Timestamp, Test Name, URL/Endpoint, Status, Execution Time (s), Date


Example:

1756988821472, GitHub API Test, api.github.com, Passed, 0.735, 2025-09-04T17:57:01.475151400


CSVExporter.java handles adding results during the test and appending them at the end.

Notes

Ensure you don’t run both Reporter.java and TestSuiteReporter.java at the same time, as it may duplicate CSV entries.

API tests use REST Assured for status code validation.

UI tests use Selenium WebDriver for browser automation.


Contributing

1. Fork the project.

2. Create a branch: git checkout -b feature-name

3. Commit your changes: git commit -m "Add new feature"

4. Push to the branch: git push origin feature-name

5. Submit a pull request.


License

This project is licensed under the MIT License.

---
