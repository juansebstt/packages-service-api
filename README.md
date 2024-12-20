# Package Service API

## Overview

The Package Service API is a Spring Boot-based microservice responsible for managing package-related operations, including creating, updating, retrieving, and deleting packages. This service handles package dimension validations and sends eligibility events via Kafka to the Eligibility Microservice. It is part of a larger microservices architecture and uses a PostgreSQL database for dedicated data management.

## Features

- **Create Package**: Registers a new package with necessary details and validates package dimensions.
- **Update Package**: Updates the recipient's details for an existing package.
- **Delete Package**: Removes a package from the system by its tracking number.
- **Get Package Information**: Retrieves content details for a specific package based on its tracking number.

## Architecture

The Package Service API follows a layered architecture:

- **Common**: Contains constants, entities, and data transfer objects (DTOs).
- **Controller**: Defines REST endpoints and maps them to service methods.
- **Repository**: Interacts with the PostgreSQL database for CRUD operations.
- **Service**: Contains business logic for managing package-related operations.

### Folder Structure

```rust
packages-service-api
│
├── common
│   ├── constant
│   ├── dto
│   └── entity
│
├── controller
│   └── impl
│
├── repository
│
└── service
    └── impl
```

- **constant**: Holds API path constants.
- **dto**: Contains Data Transfer Objects for requests and responses (e.g., `CreatePackageRequest`, `UpdatePackageRequest`, `PackageContentResponse`).
- **entity**: Includes `PackageModel`, which represents the packages table in the database.
- **controller**: Contains the controller layer, managing HTTP requests and service method mappings (`PackageController`).
- **repository**: Defines `PackageRepository` for database interactions.
- **service**: Implements business logic for package operations (`PackageServiceImpl`).

## Endpoints

1. **Create Package**
    - **URL**: `/v1/package/create`
    - **Method**: POST
    - **Headers**: `X-User-Id` – the ID of the user creating the package.
    - **Request Body**:

        ```json
        {
          "senderName": "John Doe",
          "senderEmail": "johndoe@example.com",
          "recipientName": "Jane Doe",
          "packageWidth": 20.5,
          "packageHeight": 30.0,
          "packageLength": 40.0,
          "packageWeight": 2.5
        }
        ```

    - **Response**: `CreatePackageResponse` with the generated tracking number.
2. **Update Package**
    - **URL**: `/v1/package/update_package/{trackingNumber}`
    - **Method**: PUT
    - **Request Body**:

        ```json
        {
          "recipientName": "Jane Smith",
          "recipientAddress": "123 New Street"
        }
        ```

    - **Response**: `204 No Content` if the update was successful.
3. **Delete Package**
    - **URL**: `/v1/package/delete_package/{trackingNumber}`
    - **Method**: DELETE
    - **Response**: `204 No Content` if deletion was successful.
4. **Get Package Information**
    - **URL**: `/v1/package/package_information`
    - **Method**: GET
    - **Headers**: `X-User-Id` – the tracking number of the package.
    - **Response**: `PackageContentResponse` containing package details.

## Database Configuration

The service connects to a PostgreSQL database with these settings:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/packages-db
    username: postgres
    password: 1234
  jpa:
    hibernate:
      ddl-auto: update

```
> [!NOTE]
> Make sure to replace the database URL, username, and password with your actual configuration.

## Technologies Used

- **Spring Boot**: Backend framework for building Java microservices.
- **PostgreSQL**: Relational database for package data storage.
- **Spring Data JPA**: For interacting with the PostgreSQL database.
- **Kafka**: Event streaming for communicating with the Eligibility Microservice.
- **Spring Cloud Stream**: Messaging abstraction used to send events.

## Related Microservices

The system consists of multiple microservices that work together to provide comprehensive functionality. Below is a list of all the microservices in the system, with links to their respective repositories:

- [**users-service-api**](https://github.com/juansebstt/users-service-api): Handles user management, including registration, profile updates, and account data.
- [**email-kafka-microservice**](https://github.com/juansebstt/email-kafka-microservice): Manages asynchronous email event processing using Kafka for reliable messaging.
- [**notifications-microservice-api**](https://github.com/juansebstt/notifications-microservice-api): Sends notifications based on triggered events from other services.
- [**email-authentication-service-api**](https://github.com/juansebstt/email-authentication-service-api): Manages email-based authentication and verification processes.
- [**email-api-gateway**](https://github.com/juansebstt/email-api-gateway): Serves as the entry point for routing requests to various microservices.
- [**letter-service-api**](https://github.com/juansebstt/letter-service-api): Manages letters, including creation, storage, and retrieval.
- [**packages-service-api**](https://github.com/juansebstt/packages-service-api): Manages package-related operations, including tracking and status updates.

## Getting Started

1. **Clone the repository**:

    ```bash
    git clone https://github.com/juansebstt/packages-service-api
    ```

2. **Navigate to the project directory**:

    ```bash
    cd packages-service-api
    ```

3. **Build the project**:

    ```bash
    mvn clean install
    ```

4. **Run the application**:

    ```bash
    mvn spring-boot:run
    ```

   The service will be running on `http://localhost:8080`.


## Security

This service uses JWT authentication. Include a valid JWT token in the headers for each request, with `X-User-Id` to identify the user making the request.
