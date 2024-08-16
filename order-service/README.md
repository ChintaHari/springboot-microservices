# Order Service Microservice

The **Order Service** microservice is part of a distributed system that handles order management. It communicates with a payment service to process payments and manages the order lifecycle in the system.

## Overview

This microservice allows users to:
- Place an order and process payment.
- Retrieve order details by order ID.

## Dependencies

This project utilizes several dependencies to function correctly. Key dependencies include:

- **`Spring Boot Starter Web`**: For building web applications, including RESTful services.
- **`Spring Boot Starter Data JPA`**: For data persistence using Spring Data JPA and Hibernate.
- **`Spring Boot Starter Eureka Client`**: For service discovery with Netflix Eureka.
- **`Spring Cloud Config`**: For externalized configuration management in a microservices architecture.
- **`H2 Database`**: An in-memory database for development and testing.
- **`Lombok`**: For reducing boilerplate code by generating getters, setters, and constructors.
- **`RestTemplate`**: For synchronous client-side HTTP access.

Refer to the `pom.xml` file for all required dependencies.

## Configuration

### Application Properties

The application-specific properties are defined in `src/main/resources/application.properties`. Below are key configurations:

```properties
# Application Name
spring.application.name=order-service

# Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Debug Logging
logging.level.org.springframework.web=DEBUG

# Load Balancer Configuration
spring.cloud.loadbancer.ribbon.enabled=false
```

### YAML Configuration

Additional configurations are defined in `src/main/resources/application.yml`:

```yaml
server:
    port: 9192

spring:
    h2:
        console:
            enabled: true
    application:
        name: ORDER-SERVICE

logging:
    file:
        name: C:/Users/hkhar/Desktop/logs/microservice.log
```

### Bootstrap Configuration

For centralized configuration, the bootstrap settings are defined in `src/main/resources/bootstrap.yml`:

```yaml
spring:
    cloud:
        config:
            uri: http://localhost:9196
```

## Endpoints

### POST /order/bookOrder

**Description:**  
This endpoint allows users to book an order and process the payment.

**Request Body:**  
`TransactionRequest` object containing Order and Payment details.

**Response:**  
`TransactionResponse` containing order details, transaction ID, and a status message.

**Example Request:**
```json
{
  "order": {
    "id": 1,
    "name": "Sample Order",
    "quantity": 2,
    "price": 100.0
  },
  "payment": {
  }
}
```

### GET /order/getOrder/{orderId}

**Description:**  
This endpoint fetches the details of a specific order by order ID.

**Path Variable:**  
`orderId` - The ID of the order to retrieve.

**Response:**  
`TransactionResponse` containing order details, transaction ID, and a status message.





