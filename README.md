# <img src="assets/selenium-logo.png" alt="Selenium" width="24"> Automation Exercise Selenium Test Automation Framework

A **Java**-based test automation framework for the [Automation Exercise](https://automationexercise.com) application,
combining **Selenium** and **REST Assured** for comprehensive UI and API testing, with **Cucumber** BDD, reusable design
patterns, and maintainable
architecture. Integrates **GitHub Actions** for continuous integration, **ExtentReports** for interactive reporting, and
**Log4j2** for structured logging, supporting reliable test execution, efficient debugging, and scalability.

## 📑 Table of Contents

- [🏗️ Architecture & Design Patterns](#-architecture--design-patterns)
- [🛠️ Tech Stack](#-tech-stack)
- [🧪 Test Coverage Summary](#-test-coverage-summary)
    - [🔍 UI Testing: 26/26 tests passed (100%)](#-ui-testing-2626-tests-passed-100)
    - [⚡ API Testing: 14/14 tests passed (100%)](#-api-testing-1414-tests-passed-100)
- [📁 Project Structure](#-project-structure)
- [🚀 Getting Started](#-getting-started)
    - [🔧 Prerequisites](#-prerequisites)
    - [📥 Installation](#-installation)
- [🎯 Running Tests](#-running-tests)
    - [🥒 Test Execution via CucumberTestRunner](#-test-execution-via-cucumbertestrunner)
        - [1. Run All Tests](#1-run-all-tests)
        - [2. Run All UI Tests](#2-run-all-ui-tests)
        - [3. Run All API Tests](#3-run-all-api-tests)
        - [4. Run Specific Functionality](#4-run-specific-functionality)
        - [5. Run Specific Test Case](#5-run-specific-test-case)
    - [▶️ Test Execution via Maven](#-test-execution-via-maven)
    - [🏷️ Tag Hierarchy](#-tag-hierarchy)
- [📊 Reporting](#-reporting)
- [📝 Logging](#-logging)
    - [🎚️ Levels](#-levels)
    - [🧾 Format](#-format)
- [🚦 Continuous Integration](#-continuous-integration)
    - [🔄 Workflow Steps](#-workflow-steps)
- [⚙️ Configuration](#-configuration)
- [📄 License](#-license)

## 🏗️ Architecture & Design Patterns

This framework incorporates industry-standard design patterns and best practices to ensure maintainability, reliability,
and efficient test execution:

- **Page Object Model (POM)**: Centralizes UI element locators and page interactions, simplifying maintenance.
- **Singleton Pattern**: Ensures a single browser instance is managed and reused throughout the test execution
  lifecycle.
- **Behavior-Driven Development (BDD)**: Uses Cucumber feature files written in Gherkin to define test scenarios in a
  human-readable format.
- **Explicit Waits**: Synchronizes test execution with application behavior by waiting for specific conditions, reducing
  timing-related test failures.
- **Test Data Generation**: Leverages JavaFaker to generate realistic and dynamic test data, supporting varied and
  repeatable
  test scenarios.
- **Comprehensive Logging**: Uses Log4j 2 to record execution events and relevant diagnostic information.
- **Test Execution Reporting**: Integrates ExtentReports to generate interactive HTML reports with execution results.

[⬆ Back to Table of Contents](#-table-of-contents)

## 🛠️ Tech Stack

| Component          | Technology         | Version |
|--------------------|--------------------|---------|
| **Language**       | Java               | 21      |
| **Test Framework** | JUnit 5 (Jupiter)  | 6.1.0   |
| **BDD Tool**       | Cucumber           | 7.34.3  |
| **UI Automation**  | Selenium WebDriver | 4.44.0  |
| **API Automation** | REST Assured       | 6.0.1   |
| **Build Tool**     | Maven              | 3.9.16  |
| **Logging**        | Log4j 2            | 2.26.0  |
| **Test Data**      | JavaFaker          | 1.0.2   |
| **File Utilities** | Apache Commons IO  | 2.22.0  |
| **Reporting**      | ExtentReports      | 5.1.2   |

[⬆ Back to Table of Contents](#-table-of-contents)

## 🧪 Test Coverage Summary

### 🔍 UI Testing: 26/26 tests passed (100%)

- **Authentication**: User authentication and registration flows - **5** tests.
- **Common**: Home page, contact us, and subscription functionality - **6** tests.
- **Orders**: Checkout process - **5** tests.
- **Products**: Product browsing and shopping cart functionality - **10** tests.

### ⚡ API Testing: 14/14 tests passed (100%)

- **Authentication**: User authentication flows - **4** tests.
- **Brands**: Brand-related operations - **2** tests.
- **Products**: Product-related operations - **4** tests.
- **User Account**: User account management - **4** tests.

[⬆ Back to Table of Contents](#-table-of-contents)

## 📁 Project Structure

```
automation-exercise-atf/
├── .github/                                  # GitHub workflows
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/stefan/automation/
│   │   │       ├── context/                  # Test execution context and shared state
│   │   │       ├── managers/                 # Driver, wait, and resource managers
│   │   │       ├── models/                   # Data models for test objects
│   │   │       ├── pageobjects/              # Page Object Model implementations
│   │   │       └── stepdefinitions/          # Cucumber step definitions for UI and API tests
│   │   │
│   │   └── resources/
│   │       ├── features/
│   │       │   ├── api/                      # API test feature files
│   │       │   └── ui/                       # UI test feature files
│   │       ├── config.properties             # Application and environment configuration
│   │       └── log4j2.xml                    # Logging configuration
│   │
│   └── test/
│       └── java/
│           └── com/stefan/automation/
│               └── CucumberTests.java        # Cucumber test runner
│
├── .dockerignore                             # Files excluded from Docker build context
├── .gitignore                                # Files excluded from version control
├── Dockerfile                                # Docker image build configuration
├── LICENSE                                   # Project license
├── pom.xml                                   # Maven dependencies and build configuration
└── README.md                                 # Project documentation
```

[⬆ Back to Table of Contents](#-table-of-contents)

## 🚀 Getting Started

### 🔧 Prerequisites

- **Java 21** or higher
- **Maven 3.9.16** or higher

### 📥 Installation

1. **Clone the repository**
   ```
   git clone https://github.com/stefan123283/automation-exercise-atf.git
   ```

2. **Navigate to the project directory**
    ```
   cd automation-exercise-atf
   ```

[⬆ Back to Table of Contents](#-table-of-contents)

## 🎯 Running Tests

### 🥒 Test Execution via CucumberTestRunner

Tests are executed through the `CucumberTestRunner` class by modifying the `@ConfigurationParameter` annotation with
appropriate Cucumber tags.

#### 1. **Run All Tests**

```java
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "")
```

#### 2. **Run All UI Tests**

```java
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@ui")
```

#### 3. **Run All API Tests**

```java
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@api")
```

#### 4. **Run Specific Functionality**

```java
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@ui and @authentification")
```

#### 5. **Run Specific Test Case**

```java
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@loginUserWithCorrectEmailAndPassword")
```

### ▶️ Test Execution via Maven

Tests can also be executed using Maven from the project root. For a full test run, use:

```bash
mvn clean test
```

### 🏷️ Tag Hierarchy

Each feature file is organized with three levels of tags for flexible targeting:

```gherkin
@ui                                           # Level 1: Test Type (UI or API)
@authentification                             # Level 2: Feature/Module
@loginUserWithCorrectEmailAndPassword         # Level 3: Specific Test Case (Unique)
Scenario: Login with correct email and password
...
```

[⬆ Back to Table of Contents](#-table-of-contents)

## 📊 Reporting

Test execution reports are automatically generated using the **ExtentReports** library, providing a detailed summary of
test results. Screenshots are also captured for failed tests to simplify debugging and troubleshooting.

- **Report location**: `reports/ExtentReport.html`
- **Screenshots location**: `reports/screenshots/`

[⬆ Back to Table of Contents](#-table-of-contents)

## 📝 Logging

The project uses **Log4j2** for logging application events and providing visibility into test execution.

Logs are written to both the console and a log file (`logs/application.log`), making them accessible during test
execution and available for later analysis.

### 🎚️ Levels

- `DEBUG` - detailed debugging information.
- `INFO` - general information about execution progress.
- `WARN` - warnings about potential issues.
- `ERROR` - errors encountered during execution.

The active logging level is controlled by the root logger configuration in the `log4j2.xml` file. By default, it is set
to
`INFO`.

### 🧾 Format

```text
yyyy-MM-dd HH:mm:ss [thread] LEVEL LoggerName - Message
```

[⬆ Back to Table of Contents](#-table-of-contents)

## 🚦 Continuous Integration

The project uses **GitHub Actions** to automatically execute the Selenium test suite in a CI environment whenever
changes
are pushed to the repository.

The workflow is defined in the `.github/workflows/` directory and runs on an Ubuntu environment.

### 🔄 Workflow Steps

1. Checks out the repository.
2. Sets up Java 21 using the Eclipse Temurin distribution.
3. Configures Maven dependency caching to improve build efficiency.
4. Executes the test suite using mvn clean test.
5. Uploads the generated Extent Report as a workflow artifact, even if the tests fail.

[⬆ Back to Table of Contents](#-table-of-contents)

## ⚙️ Configuration

The project uses a `config.properties` file to centralize application settings and test execution parameters.

The configuration includes the following properties:

- `applicationUrl` – Specifies the base URL of the application under test.
- `pageLoadWait` – Defines the maximum wait time for page loading, in seconds.
- `explicitWait` – Defines the maximum wait time for explicit wait conditions, in seconds.
- `headlessMode` – Controls whether the browser runs in headless mode, without a visible UI.

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

[⬆ Back to Table of Contents](#-table-of-contents)
