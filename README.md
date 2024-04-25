# MicroService
# Jackpot MicroService Project

## Overview
This repository contains the Jackpot MicroService, a Spring Boot-based service designed for managing jackpot operations. The service offers a REST API for interaction.

## API Documentation
Initially, it was planned to use Swagger (Springfox) for documenting the API and to provide an easy-to-use interactive UI for testing API endpoints directly through the browser. This would have facilitated the presentation and testing of the APIs during development and client integration.

### Issue with Swagger and Spring Boot 3
During the development, I encountered compatibility issues between Springfox Swagger and Spring Boot 3. As of the latest updates, Springfox does not fully support Spring Boot 3, which led to conflicts and errors when attempting to integrate Swagger for API documentation.

### How to Run Tests

mvn clean test

- Clone the repository and navigate to the project directory.
- Use the command `./mvnw spring-boot:run` (or `mvnw spring-boot:run` on Windows) to start the application.
- The service runs on `http://localhost:8080`.

## API Endpoints

Below are the available endpoints in the Jackpot MicroService:

### Clients

1. **List All Clients**
   - **Endpoint**: `/client/all`
   - **Description**: Retrieves a list of all clients.


2. **Get Client**
   - **Method**: GET
   - **Endpoint**: `/client/{id}`
   - **Description**: Retrieves details about a specific client.

3. **Add Client**
   - **Method**: POST
   - **Endpoint**: `/client/add`
   - **Description**: Adds a new client.

### Jackpots

4. **Update Jackpot**
   - **Method**: POST
   - **Endpoint**: `/add-to-jackpot/{id}`
   - **Description**: Adds an amount to the client's jackpot.
   

5. **Check Jackpot Availability**
   - **Method**: GET
   - **Endpoint**: `/checkAvailability/{id}`
   - **Description**: Checks if the client's jackpot is available for use based on defined criteria.


## Additional Information

- For testing these APIs, we recommend using Postman.
- The database used for this project is H2, and the database console can be accessed at `http://localhost:8080/h2-console` with the JDBC URL `jdbc:h2:mem:testdb`.
- i have already created an exemple in data.sql
