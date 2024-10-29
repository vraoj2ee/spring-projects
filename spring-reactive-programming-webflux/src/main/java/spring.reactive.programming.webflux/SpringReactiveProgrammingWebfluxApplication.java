package spring.reactive.programming.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This example demonstrates a simple end-to-end Spring Boot application using
 * Spring WebFlux and reactive programming principles. You can expand this by adding
 * error handling, validation, and more complex logic as needed.
 *
 * Reactive Programming
 * Overview: A programming paradigm that focuses on non-blocking, asynchronous data streams. It allows developers to build applications that can react to changes and events in real-time.
 * Key Concepts: It revolves around the idea of observables and observers, where data flows asynchronously and events trigger reactions.
 * Spring WebFlux
 * Overview: A part of Spring that supports reactive programming. It allows developers to build reactive applications using Project Reactor.
 * Features:
 * Non-blocking I/O: Enables handling of a large number of concurrent connections with less resource usage.
 * Reactive Streams: Supports the reactive streams specification, providing a standard for asynchronous stream processing.
 * Example Use Cases
 * Web Applications: Building responsive web applications that can handle a large number of users concurrently.
 * APIs: Creating RESTful APIs that return data asynchronously, improving performance and scalability.
 * Real-time Applications: Applications like chat systems or live notifications that require real-time data updates.
 *
 * Explanation of Key Sections:
 * Dependencies:
 * spring-boot-starter-webflux: Adds support for building reactive web applications.
 * spring-boot-starter-data-r2dbc: Enables R2DBC support for reactive database operations.
 * r2dbc-mysql: Provides the R2DBC driver for MySQL.
 * spring-boot-starter-validation: Adds support for bean validation.
 * spring-boot-starter-test: Adds testing support (JUnit, Mockito, etc.).
 * Build Plugin:
 * spring-boot-maven-plugin: This plugin allows you to run and package your Spring Boot application easily.
 *
 *
 *
 * R2DBC  for MySQL vs spring-boot-starter-data-r2dbc why
 * ChatGPT said:
 *
 * ChatGPT
 * The confusion between R2DBC for MySQL and spring-boot-starter-data-r2dbc often arises from their roles in a Spring Boot application.
 * Here’s a breakdown of each and their purposes:
 * he confusion between R2DBC for MySQL and spring-boot-starter-data-r2dbc often
 * arises from their roles in a Spring Boot application. Here’s a breakdown of each and
 * their purposes:  1. R2DBC for MySQL What It Is: R2DBC (Reactive Relational Database
 * Connectivity) is an API for reactive programming with SQL databases. It provides a way to
 * interact with relational databases in a non-blocking manner. Driver: The R2DBC MySQL
 * driver (mysql-r2dbc) specifically enables applications to connect to MySQL databases
 * in a reactive way. This driver handles the actual database connections and
 * operations using R2DBC. Usage: You'll use the MySQL R2DBC driver when you need to
 * establish a connection to a MySQL database in a reactive Spring application. 2.
 * spring-boot-starter-data-r2dbc What It Is: This is a Spring Boot starter that provides the necessary
 * dependencies and configuration for using Spring Data with R2DBC. It simplifies the setup
 * and integration of R2DBC with Spring applications. Features: It includes support
 * for repositories, which allow you to easily create CRUD operations, as well as
 * other features like reactive transaction management and query derivation. Usage:
 * When you include this starter in your project, it automatically brings in the
 * necessary dependencies, including the R2DBC driver for the database you are using (like
 * MySQL). Key Differences Functionality: R2DBC for MySQL is the low-level driver that
 * connects to the database. spring-boot-starter-data-r2dbc is the higher-level framework
 * that provides an abstraction over R2DBC, making it easier to work with database
 * operations using Spring’s repository pattern. Integration: Using R2DBC directly means you
 * will be dealing with the connection factory, connection pooling, and queries
 * manually. Using spring-boot-starter-data-r2dbc allows you to leverage Spring Data's
 * repository pattern, which abstracts much of the boilerplate code and provides a more
 * straightforward way to interact with your database. Conclusion In summary, if you're
 * developing a Spring Boot application that needs to interact with a MySQL database
 * reactively, you should include both:  R2DBC MySQL Driver for the actual database
 * connection. spring-boot-starter-data-r2dbc for Spring Data support, simplifying data
 * access and repository management. By using both together, you can build a reactive
 * application that takes advantage of Spring's powerful data access features while
 * interacting with a MySQL database in a non-blocking manner.
 * */

@SpringBootApplication
public class SpringReactiveProgrammingWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveProgrammingWebfluxApplication.class, args);
	}

}
