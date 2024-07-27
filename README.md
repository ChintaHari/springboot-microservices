# Microservices Architecture with Spring Boot and Eureka

## Project Overview

This project demonstrates a microservices architecture using Spring Boot, integrating three main components: Order Service, Payment Service, and a Eureka Service Registry. The architecture allows for robust service discovery, registration, and a decoupled mechanism for order processing and payment management in a cloud-native environment.

## Features

- **Order Service**: Manages order processing, integrates with Payment Service to handle payments.
- **Payment Service**: Handles payment transactions, simulates payment processing with a random success or failure response.
- **Eureka Service Registry**: Central service registry that enables service discovery and integration among microservices.

## Pre-requisites

- Java JDK 17
- Maven 3.6+
- Spring Boot 2.5.4
- Spring Cloud 2020.0.3
- An IDE (IntelliJ IDEA, Eclipse, etc.)
- H2 Database (embedded for development)
- Lombok Plugin (for your IDE)

## Tech Stack

- **Spring Boot**: Framework for creating stand-alone, production-grade Spring based applications.
- **Spring Cloud Netflix Eureka**: Service registry for resilient service discovery.
- **Spring Data JPA**: To persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
- **H2 Database**: In-memory database for quick development and testing of applications.
- **Lombok**: Java library tool to minimize/remove boilerplate code.
- **RestTemplate**: For RESTful communication between microservices.
- **Maven**: Dependency management and project build tool.

# Project Setup and Local Development

1. **Clone the Repository**:

    ```bash
    git clone git@github.com:ChintaHari/springboot-microservices.git
    cd springboot-microservices
    ```
2. **Start the Eureka Service Registry**:
    Navigate to the Eureka Service Registry directory and run:

    ```bash
       mvn spring-boot:run
    ```
    
    This service will start on port 8761.

3. **Start the Order Service**:
    Open a new terminal, navigate to the Order Service directory, and execute:

    ```bash
    mvn spring-boot:run
    ```
    
    This service will be available on port 9192.

4. **Start the Payment Service**:
    Open another new terminal, navigate to the Payment Service directory, and execute:

    ```bash
    mvn spring-boot:run
    ```
    
    This service will run on port 9191.

## Access the H2 Database Console

For both the Order and Payment services, you can access the H2 console at:

- Order Service: [http://localhost:9192/h2-console](http://localhost:9192/h2-console)
- Payment Service: [http://localhost:9191/h2-console](http://localhost:9191/h2-console)

Use the JDBC URL as configured in your `application.properties`.

## API Endpoints

### Order Service

- `POST /order/bookOrder`: Endpoint to create and process an order, integrated with the Payment Service for payment processing.

### Payment Service

- `POST /payment/doPayment`: Endpoint to simulate payment processing.

## Testing the Application

To test the integration and functionality, you can use Postman or any other API testing tool to send requests to the endpoints listed above.

