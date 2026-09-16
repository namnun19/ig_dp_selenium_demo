# DP UI Test Automation

This repository contains a UI test automation exercise I put together for an interview. The test navigates the DP website, interacts with the footer links, handles tab switching, and validates URLs and page titles using the Page Object Model (POM) design pattern.

## Tech Stack
* [**Java**](https://dev.java/)
* [**Selenium WebDriver**](https://www.selenium.dev/documentation/webdriver/)
* [**TestNG**](https://testng.org/)
* [**Maven**](https://maven.apache.org/)

## Directory Structure
* `src/main/java/com/dp/pages/`: Contains the Page Object classes (`BasePage`, `DPHomePage`, `PrivacyPolicyPage`).
* `src/test/java/com/dp/`: Contains the TestNG test script (`DPTest`).
* `pom.xml`: Manages the Maven dependencies (Selenium and TestNG).

## How to Run

To execute the test locally, ensure you have Java and Maven installed on your machine.

Open your terminal, navigate to the root directory of this project, and run:

```bash
mvn clean test