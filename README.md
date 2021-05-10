# API Test Automation using RestAssured for Restful-Booker


- Rest Assured enables you to test REST APIs using java libraries and integrates well with different build management tools. 
- It has very efficient matching techniques, using different libraries like Hamcrest , Json Assert so asserting your expected results is also pretty straight forward. 
- Rest Assured has methods to fetch data from almost every part of the request and response no matter how complex the JSON structures are.
- Allure is an open sourced framework that leverages junit or testng test results to create an HTML report with both high level and detailed views.

**Pre-requisites before running this code on your local:**

- You should have Gradle and Java installed on your local system and to check if it is correctly installed.

   _gradle -v_

   _java -v_

- Other dependencies are present in build.gradle file

**How to Run Tests** **(Create,Update and Delete Request):**

Use below command to run the whole test suite:

   _gradle clean test_
 
To Generate Allure Report, run below commands after running the test: 

  _allure serve allure-results_

**How to Verify Report:**

Access below file and open it using any browser:

_rest-assured-restful-booker/build/reports/tests/test/index.html_

**Sample Test Results are available at:**

_rest-assured-restful-booker/results_

**Some of the recommendations/improvements to scale/stabilize this framework :**
* Dockerize and run the framework as part of your daily builds
* Parameterising your Data using TestNG Annotations or using any external Data Source like csv. I have used Faker library which suited the use case
* Running Parallel tests using Java multithreading concepts
* Implementing the same in BDD Style so that reports becomes much readable
* Logging and buiding generic Specifications for Request and Response as our framework grows.
