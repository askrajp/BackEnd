# Academy Management API

This project is a backend API designed to automate processes for an academy, using Spring Boot. The aim was to streamline scheduling, session purchases, and communication with coaches. Although the project was left unfinished due to time constraints, particularly balancing coaching responsibilities and development, it provides a solid foundation for a comprehensive academy management system.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies](#technologies)
- [Setup](#setup)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Overview
The Academy Management API aims to automate and simplify various administrative tasks within an academy setting. This includes scheduling classes, handling session purchases, and facilitating communication between students and coaches.

## Features
- **Scheduling**: Automates the booking and management of classes and sessions.
- **Session Purchases**: Allows students to buy sessions directly through the API.
- **Coach Communication**: Enables students to contact their coaches and schedule meetings.

## Technologies
- **Spring Boot**: Java-based framework for building the API.
- **Hibernate**: ORM framework for database interaction.
- **MySQL**: Relational database for data storage.
- **JWT**: JSON Web Tokens for authentication.
- **Swagger**: API documentation.

## Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/academy-management-api.git
    ```
2. Install dependencies and build the project:
    ```bash
    cd academy-management-api
    mvn clean install
    ```
3. Configure environment variables:
    Create an `application.properties` file in the `src/main/resources` directory and add your configuration:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/yourdbname
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    jwt.secret=your_jwt_secret
    ```
4. Start the server:
    ```bash
    mvn spring-boot:run
    ```

## Usage
After setting up the project, you can use tools like Postman to interact with the API. Detailed documentation of the endpoints is provided through Swagger.

## Endpoints
- **Authentication**
  - `POST /api/auth/register`: Register a new user.
  - `POST /api/auth/login`: Login a user.

- **Classes**
  - `GET /api/classes`: Get all classes.
  - `POST /api/classes`: Create a new class.

- **Sessions**
  - `GET /api/sessions`: Get all sessions.
  - `POST /api/sessions`: Purchase a session.

- **Coaches**
  - `GET /api/coaches`: Get all coaches.
  - `POST /api/coaches/contact`: Contact a coach.

For detailed documentation, visit `http://localhost:8080/swagger-ui.html`.

## Contributing
Contributions are welcome! If you have ideas for new features or improvements, feel free to fork the repository and submit a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
