# Selenium Cucumber BDD Java - SauceDemo
End-to-end Selenium tests implemented with Java, Maven and Cucumber BDD for the SauceDemo sample app. This repository provides Page Object Model, cross-browser support, headless mode, parallel execution, and Allure reporting.


## Features
- Page Object Model architecture
- Cucumber BDD (Gherkin) feature files
- Cross-browser support (Chrome / Firefox)
- Headless mode for CI
- Parallel execution support
- Allure test reporting
- Configurable via command-line properties

## Repository layout
- `pom.xml` — Maven project file and dependencies
- `src/test/java` — test code (pages, stepdefs, runners, Utils)
- `src/test/resources` — `features`, `config.properties`, test data
- `target` — build output and test results
- `target/allure-results` — Allure results for report generation

## ▶️ Test Run Video

You can watch the full execution video here:

👉 **[Watch Test Run Video](https://drive.google.com/file/d/171PAHz1u3QG1iEjjs1GrTqYhar3yJNhY/view?usp=sharing)**  


## Quick start

1. Clone the repo:
    - `git clone https://github.com/MahmoudKhalilx/CucumberBDD_SauceDemo.git`

2. Run default tests (Chrome):
    - `mvn clean test`

3. Run Firefox or Chrome:
    - `mvn clean test -Dbrowser=firefox`

4. Run headless:
    - `mvn clean test -Dheadless=true -Dbrowser=chrome`

5. Generate and view Allure Report
   - `allure serve target/allure-results`
