# Bookstore API Test Automation

![Java](https://img.shields.io/badge/Java-21-blue)
![Gradle](https://img.shields.io/badge/Gradle-7.6-green)
![RestAssured](https://img.shields.io/badge/RestAssured-5.5.1-yellow)
![JUnit](https://img.shields.io/badge/JUnit-5.12.1-orange)
![Allure](https://img.shields.io/badge/Allure-2.29.1-purple)

## Overview

This project automates the testing of the Bookstore API using modern testing frameworks and tools. It ensures that the API functions as expected and maintains high-quality standards.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Running the Tests](#running-the-tests)
- [Viewing Test Reports](#viewing-test-reports)
- [Continuous Integration](#continuous-integration)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Automated API Testing**: Validates various endpoints of the Bookstore API.
- **Parameterized Test Execution**: Allows selection of environment and thread count for test runs.
- **Comprehensive Test Reports**: Generates detailed Allure reports for test results.

## Technologies Used

- **Java 21**: Core programming language.
- **Gradle 7.6**: Build automation tool.
- **RestAssured 5.5.1**: For testing RESTful services.
- **JUnit 5.12.1**: Testing framework.
- **Allure 2.29.1**: For generating test reports.
- **Owner 1.0.12**: For handling configuration properties.
- **AssertJ 3.27.3**: Fluent assertions for Java.
- **JavaFaker 1.0.2**: For generating fake data.

## Prerequisites

- **Java Development Kit (JDK) 21**: Ensure it's installed and `JAVA_HOME` is set.
- **Gradle 7.6**: Installed and configured in your system's PATH.

## Getting Started

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/poltorak-vladyslav/bookstore-tests.git
   cd bookstore-tests
   ```

2. **Install Dependencies**:
   ```bash
   ./gradlew clean build
   ```

## Running the Tests

Execute tests with customizable options:

```bash
./gradlew clean test -Denv=dev -Dthreads=4
```

- **`env`**: Specifies the environment (`dev`, `qa`).
- **`threads`**: Number of threads for parallel test execution.

## Viewing Test Reports

After running the tests, generate and view the Allure report:

```bash
./gradlew allureServe
```

Access the report at `http://localhost:8080`. Stop the server with `Ctrl+C`.

## Continuous Integration

This project uses GitHub Actions for CI/CD. The pipeline:

- Runs on pushes to the `main` branch and can be triggered manually.
- Allows selection of environment and thread count during manual runs.
- Executes tests and publishes Allure reports.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.