

# Selenium BDD Java Project

## Running the Tests
- **To run tests in default browser (Chrome):**
    mvn clean test
- **To run tests in Firefox browser:**
    mvn clean test -Dbrowser=firefox
- **To run tests in headless mode:**
    mvn clean test -Dheadless=true -Dbrowser=firefox
- **To run tests in parallel mode:**
     mvn clean test -Dparallel=true  
- **To generate and view Allure report:**
    allure serve target/allure-results

