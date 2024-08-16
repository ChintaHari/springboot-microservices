# Microservices Architecture with Spring Boot

## Project Overview

This project demonstrates a microservices architecture using Spring Boot, integrating multiple components to create a robust and scalable system. The architecture includes various services for comprehensive service management, configuration, and security, as well as centralized logging for enhanced observability.

## Features

- **Order Service**: 
  - Manages order processing.
  - Integrates with Payment Service to handle payments.

- **Payment Service**: 
  - Handles payment transactions.
  - Simulates payment processing with random success or failure responses.

- **Eureka Service Registry**: 
  - Central service registry for service discovery and registration.

- **Cloud API Gateway**: 
  - Routes incoming requests to appropriate microservices.
  - Manages API traffic and load balancing.

- **Cloud Config Server**: 
  - Fetches and serves common configuration properties from a Git repository.
  - Provides centralized configuration management.

- **Security Service**: 
  - Implements authentication and authorization using Spring Security 6.
  - Secures microservice interactions.

- **Centralized Logging**: 
  - Configured with the ELK stack (Elasticsearch, Logstash, Kibana).
  - Provides real-time log aggregation, search, and visualization.


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

## Architecture

![Architecture Diagram](images/Architecture.jpg)


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

## Microservices Documentation

- [Order Service](./order-service/README.md)
- [Payment Service](./payment-service/README.md)
- [Eureka Service Registry](./eureka-service/README.md)
- [Cloud API Gateway](./cloud-api-gateway/README.md)
- [Cloud Config Server](./cloud-config-server/README.md)
- [Security Service](./security-service/README.md)
- [Centralized Logging](./centralized-logging/README.md)


