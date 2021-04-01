# Tests for expload.com website
## UI tests:
- Main page tests
- Page should Be Opened From DirectPage
- Console Log Should Not Have any Errors
- Header should have Text "SDK COMPONENTS"
- Page should change language EN/RU
- Download readme file from GitHub and search for the desired text in it

## Technology Stack
- Java
- Gradle
- Junit5 + multi-threading runs
- Selenide (Automation framework based on Selenium)
- Selenoid (Virtualization system based on the docker)
- Allure (+Allure test ops) test report system.
- Jira integration / Jenkins integration
- Telegram piechart reporting library integration

## Screenshots
#### *Jenkins - it is an open source automation server:*
![selenoid_screenshot](src/test/resources/images/Jenkins.png)


#### *Allure Report - it is a flexible lightweight test report tool:*
![selenoid_screenshot](src/test/resources/images/allure_with_steps.png)


![selenoid_screenshot](src/test/resources/images/allure_with_steps1.png)


![selenoid_screenshot](src/test/resources/images/allure_test_body.png)


#### *Telegram notifications:*
![selenoid_screenshot](src/test/resources/images/telegram.png)


#### *Allure TestOps - it is a TMS that allows to manage all test related stuff in one place:*
![selenoid_screenshot](src/test/resources/images/AllureTestOps.png)