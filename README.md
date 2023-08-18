# Portfolio Project

![Quiz Application Logo](src/main/resources/static/quizapp.png)

## Motivation

I decided to work on this project because I simply love programming, and it brings me so much joy.
I wanted to create it not only to showcase my skills but also to have fun with it.
For me, programming is not just a job; it's a passion.

## Project Overview

The Quiz Application is a RESTful API that offers various functionalities centered around quiz management.
The core features of the application include user registration, adding,
answering questions and generating questions from the external API and
creating quizzes with question series based on categories. 
The API is designed to facilitate direct communication with the front-end through a RESTful API exposed via the Swagger
tool.

## Technologies Used

The Quiz Application is built using the following technologies:

- Java 17
- Spring Boot 3
- Hibernate
- Spring Security (JWT)
- Database: PostgreSQL
- Flyway
- Groovy, Spock (Unit Testing)
- jUnit, Mockito (Integration Tests)
- Architecture: Domain Driven Design
- Docker
- Cloud deployment (Heroku)
- CI/CD (GitHub Actions)
- Swagger

I put in a considerable amount of effort to accurately replicate a real project within its authentic environment.
As a result, there are times when it might appear somewhat 'overengineered'.
To be honest, there were simpler approaches available, but my aim was to apply Domain-Driven Design (DDD) principles
, which led me to take this slightly more elaborate route. Plus, I factored in scalability for the project's future.
## How to Run the Project

Build the Docker image

```
docker pull davidwrz/quizapp:latest
```

Run the Docker container

```
docker run -p 8080:8080 -d quizapp
```

The application will be available at http://localhost:8080.

# Contact

If you have any questions or feedback please feel free to reach out to me at wrzosdawid95@gmail.com.