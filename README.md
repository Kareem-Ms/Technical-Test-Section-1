# Technical Test Section 1

## The main Frameworks included in the project:
- Rest-Assured
- TestNG
- Allure Report
- Json Reader for Data management

## Project Design:
- Page Object Model (POM) design pattern
- Data Driven framework
- Have a supporting Utilities package in src/main/java file path, named "utils" that includes many wrapper methods which services the project like ApiActions class

## Steps to Execute Code
- Clone the code from the Repository 
- Open POM.xml file then reload that file to install dependecies
- Go to "PlacesTests" class then run that class or you can open testng.xml file and then run thhis file
- You can access allure report by executing the following command "allure serve" in terminal after running the code

## Code Explanation
- Check the "TCs to be automated.xlsx" file in the repo to see the test cases that was automated
- in the src/main/java/org folder there is a package called "utils" this package contain helper classes like:
    - "ApiActions" which is designed to handel all the apis request methods including POST,GET,PATCH and DELETE.
    - "PropertiesManager" this class contains methods to read from a property file which exist under src/main/resources to access something like BaseUrl
    - "JsonFileManager" this class is used to read data from json file to inject these data in the test classes
    - "TestingListeners" this class implements 2 interfaces "ISuiteListener" and "ITestListener" i manily used this for logging perpouse but it could be used for example to take screenshot on failure
- in the src/main/java/org you will find a package called "pages" this package used to include all the apis that will be used in testing so for example the "GetPlaceAPI" class contain method to get place and this methods interacts with ApiActions class to form a request
- in the src/test/java/org you will find a package called "testData" this package contains one json file per each test case to achieve isolation
- in the src/test/java/org you will find a package called "tests" this package contain one test classes "PlacesTests" this class have mainly four test cases which interacts with "GetPlaceAPI.getPlace()" to get places and each test case read from a single testData file
- The tests could be separated into 4 classes but they were related to the Places so I prefered to include them in the same class
