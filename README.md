# Portfolio Project

![Quiz Application Logo](src/main/resources/static/quizapp.png)

## Motivation

I decided to work on this project because I simply love programming, and it brings me so much joy.
I wanted to create it not only to showcase my skills but also to have fun with it.
For me, programming is not just a job; it's a passion.

## Project Overview

The Quiz Application is a RESTful API that offers various functionalities centered around quiz management.
The core features of the application include user registration, adding and answering questions,
creating quizzes with question series based on categories, and generating questions from the internet based on specified
categories.
The API is designed to facilitate direct communication with the front-end through a RESTful API exposed via the Swagger
tool.

## Technologies Used

The Quiz Application is built using the following technologies:

- Java 17
- Spring Boot 3
- Hibernate
- Spring Security (JWT, Basic, OAuth2)
- Database: PostgreSQL
- Flyway
- Groovy, Spock (Unit Testing)
- jUnit, Mockito (Integration Tests)
- Architecture: Domain Driven Design
- Clean Code
- Docker
- AWS
- CI/CD (GitHub Actions)

## How to Run the Project

Follow the steps below to run the Quiz Application locally:

### Prerequisites

- Java Development Kit (JDK) 17 or higher installed
- MySQL database installed and running
- Docker installed (optional, for Docker setup)

### Clone the Repository

```bash
git clone https://github.com/your-username/quiz-application.git
cd quiz-application
```

# Build the Docker image

docker build -t quiz-app .

# Run the Docker container

docker run -p 8080:8080 -d quiz-app
The application will be available at http://localhost:8080.

# Contact

If you have any questions or feedback please feel free to reach out to me at wrzosdawid95@gmail.com.
Thank you and all the best!