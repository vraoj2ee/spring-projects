# Read Me First
The following was discovered as part of building this project:

* The original package name 'spring-reactive-programming-webflux' is invalid and this project uses 'spring_reactive_programming_webflux' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.5/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.3.5/reference/web/servlet.html)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/3.3.5/reference/web/reactive.html)
* [Spring Data Reactive MongoDB](https://docs.spring.io/spring-boot/3.3.5/reference/data/nosql.html#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

Here's a simple end-to-end example of a Spring Boot application using Spring WebFlux for reactive programming. This example will create a basic REST API that handles asynchronous data.

Step 1: Set Up Your Spring Boot Project
Using Spring Initializr

You can create a new Spring Boot project with the necessary dependencies:

Go to Spring Initializr
Select the following options:
Project: Maven Project (or Gradle)
Language: Java
Spring Boot: (latest stable version)
Dependencies:
Spring WebFlux
Spring Data Reactive MongoDB (if you want to use MongoDB)
Generate the project and download the ZIP file, then extract it.

Step 2: Create Your Application Structure
In your extracted project, create the following structure:

css
Copy code
src/main/java/com/example/reactiveapp
├── ReactiveAppApplication.java
├── controller
│   └── NumberController.java
├── model
│   └── Number.java
└── repository
└── NumberRepository.java


Configuration
application.properties

Configure your MongoDB connection in src/main/resources/application.properties:

properties
Copy code
spring.data.mongodb.uri=mongodb://localhost:27017/reactiveapp
Make sure MongoDB is running on your local machine, or adjust the URI accordingly.

Step 5: Run the Application
Navigate to your project directory in the terminal and run:
bash
Copy code
./mvnw spring-boot:run  # For Maven
# or
./gradlew bootRun       # For Gradle
Step 6: Test the Application
You can use tools like Postman or cURL to test the endpoints:

Add a number (POST request):
URL: http://localhost:8080/numbers
Body (JSON):
json
Copy code
{ "value": 5 }
Get all numbers (GET request):
URL: http://localhost:8080/numbers


========
Explanation of Key Sections:
Dependencies:
spring-boot-starter-webflux: Adds support for building reactive web applications.
spring-boot-starter-data-r2dbc: Enables R2DBC support for reactive database operations.
r2dbc-mysql: Provides the R2DBC driver for MySQL.
spring-boot-starter-validation: Adds support for bean validation.
spring-boot-starter-test: Adds testing support (JUnit, Mockito, etc.).
Build Plugin:
spring-boot-maven-plugin: This plugin allows you to run and package your Spring Boot application easily.


he confusion between R2DBC for MySQL and spring-boot-starter-data-r2dbc often arises from their roles in a Spring Boot application. Here’s a breakdown of each and their purposes:

1. R2DBC for MySQL
   What It Is: R2DBC (Reactive Relational Database Connectivity) is an API for reactive programming with SQL databases. It provides a way to interact with relational databases in a non-blocking manner.
   Driver: The R2DBC MySQL driver (mysql-r2dbc) specifically enables applications to connect to MySQL databases in a reactive way. This driver handles the actual database connections and operations using R2DBC.
   Usage: You'll use the MySQL R2DBC driver when you need to establish a connection to a MySQL database in a reactive Spring application.
2. spring-boot-starter-data-r2dbc
   What It Is: This is a Spring Boot starter that provides the necessary dependencies and configuration for using Spring Data with R2DBC. It simplifies the setup and integration of R2DBC with Spring applications.
   Features: It includes support for repositories, which allow you to easily create CRUD operations, as well as other features like reactive transaction management and query derivation.
   Usage: When you include this starter in your project, it automatically brings in the necessary dependencies, including the R2DBC driver for the database you are using (like MySQL).
   Key Differences
   Functionality:
   R2DBC for MySQL is the low-level driver that connects to the database.
   spring-boot-starter-data-r2dbc is the higher-level framework that provides an abstraction over R2DBC, making it easier to work with database operations using Spring’s repository pattern.
   Integration:
   Using R2DBC directly means you will be dealing with the connection factory, connection pooling, and queries manually.
   Using spring-boot-starter-data-r2dbc allows you to leverage Spring Data's repository pattern, which abstracts much of the boilerplate code and provides a more straightforward way to interact with your database.
   Conclusion
   In summary, if you're developing a Spring Boot application that needs to interact with a MySQL database reactively, you should include both:

R2DBC MySQL Driver for the actual database connection.
spring-boot-starter-data-r2dbc for Spring Data support, simplifying data access and repository management.
By using both together, you can build a reactive application that takes advantage of Spring's powerful data access features while interacting with a MySQL database in a non-blocking manner.

