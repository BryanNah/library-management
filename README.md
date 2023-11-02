# Library Management System with Spring Boot and Gradle

The Library Management System is a simple application that helps manage a library's users and books. It allows you to perform basic operations such as creating users, adding books, and managing book borrowing and returns.
## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Installation](#installation)
    - [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)

## Features

- Create a new user
- Fetch all users
- Add a new book
- Fetch all books
- Fetch a specific book
- Delete a book
- Borrow a book
- Return a book

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Make sure [Java](https://www.oracle.com/java/technologies/downloads/) 17 installed.
- [Spring Boot](https://spring.io/projects/spring-boot) - the application is built with Spring Boot.
- [Gradle](https://gradle.org/install/) 7 or higher installed.

## Getting Started

### Installation

Follow these steps to set up and run the application:

1. Clone the repository:

   ```sh
   git clone https://github.com/BryanNah/library-management

2. Navigate to the project directory:
   ```sh
   cd library-management

### Configuration

Configure your application properties in src/main/resources/application.properties or src/main/resources/application.yml:

   ```yaml
    spring.datasource.url=jdbc:mysql://localhost:3306/library
    spring.datasource.username=root
    spring.datasource.password=root
    spring.jpa.hibernate.ddl-auto=update
   ``` 

## Usage

Run the application using the following command:

   ```sh
   ./gradlew bootRun
   ```

The application will be accessible at http://localhost:8000.

## API Endpoints

- Create User: POST /api/users
- Fetch All Users: GET /api/users
- Add Book: POST /api/books
- Fetch All Books: GET /api/books
- Fetch Specific Book: GET /api/books/{bookId}
- Update Specific Book: PUT /api/books/{bookId}
- Delete Book: DELETE /api/books/{bookId}
- Borrow Book: POST /api/books/{bookId}/borrow
- Return Book: POST /api/books/{bookId}/return