# Selenium BDD Java Project

## Features
- Easy to maintain Page Object Model
- Cucumber BDD (Gherkin)
- Cross-browser support
- Headless mode for CI/CD
- Parallel execution
- Allure reporting
- Configurable through command line or properties file

## ▶️ Test Run Video

You can watch the full execution video here:

👉 **[Watch Test Run Video](https://drive.google.com/file/d/FILE_ID/view?usp=sharing)**  


## Running the Tests

###  Default browser (Chrome)
```
mvn clean test
```


### Run tests in Firefox
```
mvn clean test -Dbrowser=firefox
```
### Run tests in headless mode
```
mvn clean test -Dheadless=true -Dbrowser=firefox
```

✅ Run tests in parallel mode
```
mvn clean test -Dparallel=true
```
✅ Generate and view Allure Report
```
allure serve target/allure-results
```
