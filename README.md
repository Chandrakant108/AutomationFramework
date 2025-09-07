# AutomationFramework

## Overview
**AutomationFramework** is a Java-based automated testing framework that runs multiple test suites in parallel and exports the results to both Excel and a database. The framework is designed to execute web tests across multiple platforms like GitHub, Wikipedia, W3Schools, and GitHub APIs, leveraging Selenium WebDriver for browser automation.

It also supports scheduled execution, allowing tests to run automatically at specified times daily.

---

## Features

- Parallel execution of multiple test suites.
- Test results exported to Excel files and a database.
- Scheduled execution using a configurable time.
- Uses Selenium WebDriver for browser automation.
- Supports multiple browsers (Chrome, Firefox, Edge, etc.).
- Modular design for easy addition of new test suites.
- Logs detailed execution time for each test.

---

## Project Structure


AutomationFramework/
├── src/main/java/org/example/framework/schtests
│ ├── GitHubTests.java
│ ├── GitHubApiTests.java
│ ├── W3SchoolsTests.java
│ └── WikipediaTests.java
├── src/main/java/org/example/framework/scheduler
│ └── TestScheduler.java
├── src/main/java/org/example/framework/report
│ └── ExcelAndDbExporter.java
├── pom.xml
└── README.md


---

## Prerequisites

- Java JDK 23 or higher
- Maven 3.8 or higher
- Chrome/Firefox/Edge WebDriver installed (or managed via WebDriverManager)
- MySQL or any supported database for result storage (optional if only exporting to Excel)

---

## Installation

1. Clone the repository:

```bash
git clone https://github.com/yourusername/AutomationFramework.git
cd AutomationFramework


2. Build the project using Maven:

mvn clean install


Configure database connection (if using DB export) in ExcelAndDbExporter.java.

Ensure browser drivers are available or use WebDriverManager to automatically manage them.


Running the Tests
1. Manual Execution

Run the scheduler manually from the command line or IDE:

java -cp target/classes;path_to_dependencies org.example.framework.scheduler.TestScheduler


This will:

Schedule the tests for the configured time (default: 21:06).

Execute tests in parallel.

Export results to Excel and database.

Log test execution times.

2. Scheduled Execution

The TestScheduler class computes initial delay and schedules tasks daily at the specified time.

You can configure the schedule by changing:

LocalTime targetTime = LocalTime.of(21, 6);


Test Reporting

1. Excel Reports

Each test suite exports results to an Excel file with the format: TestName | Status | Duration | Timestamp.

Excel Reports

Each test suite exports results in Excel format:

Test Name	Status	Duration	Timestamp
GitHubTests	Passed	0.512s	2025-09-07 21:06
GitHubApiTests	Passed	0.808s	2025-09-07 21:06
WikipediaTests	Passed	0.714s	2025-09-07 21:06
W3SchoolsTests	Passed	0.606s	2025-09-07 21:06

2. Database Reports

Test results are inserted into a database table if configured.


Adding New Test Suites

1. Create a new class in schtests package implementing a runAllTests() method.

2. Add the test in TestScheduler:

parallelExecutor.submit(() -> runAndExport(new YourNewTest()::runAllTests));


Dependencies

Selenium Java 4.35.0

WebDriverManager 5.3.2

TestNG 7.10.2

Apache POI 5.2.3 (Excel handling)

Jackson Databind 2.18.2

MySQL Connector/J 8.0.33

SLF4J 2.0.6 (Logging)

Apache Commons Libraries (Collections, CSV, Exec, Lang3, etc.)

Troubleshooting

Chrome tab not opening: Ensure correct ChromeDriver version and WebDriverManager setup.

Database connection error: Check JDBC URL, username, password, and DB server availability.

TestScheduler static errors: Make sure to use instance method references (new Class()::runAllTests) for non-static test methods.


License

MIT License © 2025 [Chandrakant Kumar]

Contact

For questions or support, contact: [chandrakant2522006@gmail.com]