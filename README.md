## **Full Stack Automation Project**
[Short Video - Demonstration](https://drive.google.com/file/d/1ddsjZ5Gh9PACZDX_-DlhT223e2kquy_j/view?usp=sharing)
### **_This project created to demonstrate my knowledge and skills in Automation Testing._**
***
### _About_
The project demonstrates a smart automation infrastructure that allows us to test different kinds of applications that are easily maintained!
This project is based on selenium, TestNG, maven, allure report, and java version 8. Can execute our automated tests inside a docker container using Jenkins, GitHub, DockerHub, and Selenium Grid.

## Requirements
To run test on Firefox or Chrome browsers with docker you need to install:
* docker
* docker-compose
* selenium grid  
## Quick run test
provide 3 parameters
* HUB_HOST = IP address of selenium grid 
* Browser = Chrome/Firefox
* Module = support 4 modules
```
* commerce-web-module.xml
* commWeb-regression-module.xml
* map-api-module.xml
* search-duck-module.xml 
```
```bash
docker run -e HUB_HOST=localhost -e BROWSER=chrome -e MODULE=commerce-web-module.xml darkklin/finalproject
```

## Project Structure
```bash
Automation-Project/
├─ Configuration/
│  ├─ DataConfig.xml 
├─ DDTFiles/
│  ├─ product.csv
|  ├─ keyword.csv  
├─ Drivers/
│  ├─ electrondriver.exe
├─ ImageRepository/
│  ├─ logo01.png
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  ├─ extensions/
│  │  │  |  ├─ ApiAction.java
│  │  │  │  ├─ DataBaseAction.java
│  │  │  │  ├─ LoadAPI.java.java
│  │  │  │  ├─ MobileAction.java
│  │  │  │  ├─ UIActions.java
│  │  │  │  ├─ Verifications.java
│  │  │  ├─ pageObjects/
│  │  │  │  ├─ calculator/
│  │  │  │  │  ├─ MainPage.java
│  │  │  │  ├─ duckduckgo/
│  │  │  │  │  ├─ DuckduckgoPage.java
│  │  │  │  ├─ mortgage/
│  │  │  │  │  ├─ MainPage.java
│  │  │  │  ├─ toDo/
│  │  │  │  │  ├─ MainPage.java
│  │  │  │  ├─ nopCommerce/
│  │  │  │  │  ├─ CheckoutPage.java
│  │  │  │  │  ├─ HeaderPage.java
│  │  │  │  │  ├─ LoginPage.java
│  │  │  │  │  ├─ MainPage.java
│  │  │  │  │  ├─ ProductPage.java
│  │  │  │  │  ├─ RegisterPage.java
│  │  │  │  │  ├─ RegisterPage.java
│  │  │  │  │  ├─ MyaccountPage.java
│  │  │  │  │  ├─ ShoppingCartPage.java
│  │  │  ├─ utilities/
│  │  │  │  ├─ Base.java
│  │  │  │  ├─ CommonOps.java
│  │  │  │  ├─ Listeners.java
│  │  │  │  ├─ ManagePages.java
│  │  │  │  ├─ ManageDDT.java
│  │  │  │  ├─ MonteScreenRecorder.java
│  │  │  ├─ utilities/
│  │  │  |  ├─ actions/
│  │  │  │  │  ├─ WebFlowActions.java.java
│  │  │  |  ├─ DuckduckgoFlow.java
│  │  │  |  ├─ MapApiFlows.java
│  │  │  |  ├─ DuckduckgoFlow.java
│  │  │  |  ├─ MapApiFlows.java
│  │  │  |  ├─ ToDoFlows.java
│  │  │  |  ├─ WebFlows.java
│  │  │  |  ├─ WindowsCalculateFlows.java
│  ├─ test/
│  │  ├─ java/
│  │  │  ├─ sanity/
│  │  │  │  ├─ CalculaterWindows.java
│  │  │  │  ├─ CommerceWeb.java
│  │  │  │  ├─ MapAPI.java
│  │  │  │  ├─ MortgageMobile.java
│  │  │  │  ├─ ToDoListElectron.java
│  │  │  │  ├─ DuckduckgoWeb.java
│  │  │  ├─ regression/
│  │  │  │  ├─ CVVTest.java
├─ .gitignore
├─ Dockerfile
├─ Jenkinsfile
├─ healthcheck.sh
├─ pom.xml
├─ README.md
├─ commerce-web-module.xml
├─ commWeb-regression-module.xml
├─ electron-module.xml
├─ map-api-module.xml
├─ search-duck-module.xml
├─ windows-module.xml
```
### _Project Overview_
The project is an example of infrastructure for automation testing of different kinds of applications:
* Web based application
* Mobile application
* Web API
* Electron application
* Desktop application

### **_Infrastructure project includes using of:_**
* Page Object Design Pattern
* Project Layers(Extensions/Work Flows/Test Cases...)
* Support of Different Clients/Browsers
* Failure Mechanism
* Common Functionality
* External Files Support
* Reporting System (including screenshots)
* Visual Testing
* DB support
* CI support  

***

### _List of applications were used in this project:_
* NopCommerce store - eCommerce platform
* DuckDuckGo - web search engine
* Mortgage calculator - Mobile application
* DemoGoogleMap API - Web API
* Electron application
* Windows calculator - Desktop application

### _Tools & Frameworks used in the project:_
* TestNG - Testing Framework
* Listeners - interface used to generate logs and customize the TestNG reports
* MySQL Free Online DB - used for login to Grafana web page
* [Jenkins](https://www.jenkins.io/)- for tests execution
* REST Assured - for API testing
* [Allure](http://allure.qatools.ru/) Reports - as the main reporting system

### Tests Execution:
> Each of the applications has a few tests for demonstration purpose.
These tests can be developed in a very simple way, due to a lot of work with the infrastructure.
[[Sanity Tests]](https://github.com/sashka999/FullStackFinalProject/tree/master/src/test/java/SanityTests)

### _Known Issues:_
Sometimes can be conflicts with some dependencies the applications are using.
Hence, the project is for DEMO purpose only. In production it should be divided into several projects.
