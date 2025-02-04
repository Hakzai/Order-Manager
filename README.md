
# Order Manager App

This is a order manager service to receive, process and send orders with external systems. It was proposed as a technical challenge from Levva talent acquisition team.

## Purpose 

Build a service as a RESTful CRUD API that will receive and manage *Orders* from an external system. Our ordering manager should calculate the total price for the ordering, and store all its data in a database. After processing it, the orders and its products should be available to be retrieved and consulted by another external system.

## Requirements:
- Write the required API with Java and Spring Boot Framework;
- Code must follow good code practices such as a Layer Architecture pattern (such as MVC);
- It should persist data on a database (to be chosen from MySQL, PostgreSQL or H2);
- Messaging protocols can be any chosen by the dev;
- Any other framework can be used to reach final goals;
- Set a new drawing of the final model;
- Consider a quick delivery of the project;
    - It should be committed to git or even sharing screen during interview;
    - It is not needed to implement mentioned external services, but during presentation will need samples from requests and message processing;
- A new solution can be designed if desired;
- It is required to follow GitFlow steps to publish on GitHub.

**Extra-Points Requirements:**
- Check for duplicated orders;
- Garantee the service availability even with high volume of orders (from 150k to 200k per day);
- Have data consistency and allow concurrency;
- Check if the high volume can cause database bottleneck and how to avoid it. 

## Technologies Stack

**Back-end:** Java with Spring, MySQL, Apache Tomcat

**Messaging:** Kafka (running on Docker)

**Monitoring:** Actuator

**Versioning:** Git

## Roadmap

* [X]  Create the API using Spring Boot Framework
* [X]  Layer Architecture (using MVC)
* [X]  Use a relational persistance database (using MySQL running on WAMPP server)
* [X]  API Documentation with Swagger
* [X]  App monitoring with Actuator
* [X]  Published on GitHub

## Installing

Project is managed with maven. POM file is inside project.

It was written using:
*  OpenJDK 23.0.1
*  Spring Boot 3.4.2
*  Apache Maven 3.9.9
*  Apache Tomcat 9.0.96
*  Apache Kafka 3.9.0
*  Docker version 27.5.1
*  MySQL 8.0.18

To build and run make sure you're using same versions (or higher, with compatibility).

Personal tools setup:
- Spring Tool Suite 4.25.0
- WAMPP Server 3.2.2.2
- Postman Portable Version 8.5.1

## Author

Project done by Isaac Alencar (Akeir Technology)