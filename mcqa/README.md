# SMQA-Group-25
# Multiple choice Question and Answer Web App

## Introduction

This Multiple Question and Answer Quiz Software is designed to facilitate the creation and administration of quizzes with multiple questions and answers. The software is configured to run in the Eclipse IDE, making it easy for developers to set up and use.

## Database Configuration

Database parameters can be configured using the `application.properties` file located under the `src/main/resources` folder. Update the necessary properties in this file to customize the database connection.

mcqa.db script help to set the Database. 
Path: src\main\resources\mcqa.db


## Installation

Follow the steps below to set up the software in Eclipse:

1. **Unpack the Folder:**
   - Download the software package and unpack it into your desired location.

2. **Import Project into Eclipse:**
   - Open Eclipse and choose **File > Import**.
   - Select **Existing Maven Project** from the list of import options.
   - Browse to the location where you unpacked the folder and select the project.

3. **Run Maven Install:**
   - Once the project is imported, right-click on the project in Eclipse.
   - Choose **Run As > Maven Install** to install dependencies.

4. **Run as Java Application:**
   - After the Maven install is complete, right-click on the project again.
   - Choose **Run As > Java Application** to run the application.
   
   If you have the following issue while Running:

	- Web server failed to start. Port 8080 was already in use.
	 Open the Command Prompt and run the following commands
    -netstat -a -n -o | find "8080"
    -taskkill /F /PID 30292 (30292 is TaskID)


## Running Test Coverage in Eclipse

To measure test coverage in Eclipse, you can use the built-in code coverage tool. Follow these steps:


1. **Run Your JUnit Tests:**
   - Right-click on your project or a specific package or class with JUnit tests.
   - Choose **Run As > JUnit Test** or better **Run As > coverage** to execute your tests.

2. **View Code Coverage:**
   - After running the tests, open the "Coverage" tab. You can find this tab at the bottom of the Eclipse window.

3. **Analyze Code Coverage:**
   - In the "Coverage" tab, you'll see a list of covered and uncovered classes.

4. **Review Results:**
   - Analyze the coverage results to identify areas that may need additional testing.

## Additional Notes

- The built-in code coverage tool provides different color-coding for covered and uncovered code in the editor.
- You can customize the coverage highlighting by going to **Window > Preferences > Java > Editor > Mark Occurrences > Coverage**.


##Technology Stack :
•	Frontend: Thymeleaf
•	Backend: Spring Boot


properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=root
spring.datasource.password=rootpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080/login in your browser.


## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/mcqa-1.0-SNAPSHOT.jar`


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)