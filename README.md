# Legit-Task

**Legit-Task** is a Java project utilizing Maven and GitHub Actions CI/CD. This project provides a testing framework using Selenium and TestNG.

## Features

- **Automated Testing**: Includes test automation with Selenium and TestNG.
- **CI/CD Pipeline**: Integrated with GitHub Actions for continuous integration and deployment.

## Technologies Used

- **Java JDK**: Version 21
- **Maven**: Version 3.8.1
- **Testing Frameworks**:
  - Selenium Java: Version 4.20.0
  - TestNG: Version 7.10.2
- **WebDriver Manager**: Version 5.8.0

## Setup Instructions

### Prerequisites

- **Java Development Kit (JDK)**: Ensure you have JDK 21 installed.
- **Maven**: Install [Maven 3.8.1](https://maven.apache.org/install.html).

### Clone and Build

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/Legit-Task.git
    cd Legit-Task
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## Usage

- **Run Tests**: To execute tests configured via TestNG, run:

    ```bash
    mvn test
    ```

- **Running Selenium Tests**:
    - Ensure WebDriver is properly set up via WebDriverManager.
    - Customize or add your tests in the `src/test` folder.

**If there are any troubles initializing or execution of tests Please contact me**
