# Cinema Ticket Booking System
Welcome to the Cinema Ticket Booking System project! This project provides a simple RESTful API for booking and managing cinema tickets.

## Table of Contents
* [Introduction](#introduction)
* [Project Structure](#project-structure)
* [Usage](#usage)
* [Endpoints](#endpoints)
* [Dependencies](#dependencies)
* [Running the Application](#running-the-application)
* [Contributing](#contributing)

## Introduction

The Cinema Ticket Booking System allows users to:

* View available seats in the cinema.
* Purchase tickets for available seats.
* Return purchased tickets.
* Get statistics about ticket sales.

The project is built using Spring Boot and Java.

## Project Structure

The project is organized into several packages:

* `cinema.business`: Contains the business logic, including the `Cinema`, `CinemaService`, `Seat`, and `PurchasedTicket` classes.
* `cinema.business.dto`: Contains the Data Transfer Object (`SeatDTO`) used for input and output.
* `cinema.presentation`: Contains the RESTful API controller (`CinemaController`) for handling HTTP requests.
* `cinema`: Contains the main application class (`Main`) to run the Spring Boot application.

## Usage

To use this application, you can make HTTP requests to the provided endpoints (see [Endpoints](#endpoints)).

## Endpoints

* `GET /api/v1/seats`: Get information about available cinema seats.
* `POST /api/v1/purchase`: Purchase a ticket for a specific seat.
* `POST /api/v1/return`: Return a purchased ticket using a token.
* `GET /api/v1/stats`: Get statistics about ticket sales (authentication required).

For detailed information about each endpoint and their request/response formats, please refer to the `CinemaController` class in the `cinema.presentation` package.

## Dependencies

This project uses the following dependencies:

* Spring Boot
* Jackson (for JSON serialization/deserialization)
* Lombok (for reducing boilerplate code)

## Running the Application

To run the application, follow these steps:

1. Clone the repository to your local machine.
2. Ensure you have Java and Maven installed.
3. Build the project using Maven: `mvn clean install`.
4. Run the application: `mvn spring-boot:run`.

The application should now be running locally and accessible at http://localhost:8080.

## Contributing

Contributions are welcome! If you have suggestions, bug reports, or want to contribute code, please feel free to open an issue or create a pull request.