# Portfolio Project

![Quiz Application Logo](src/main/resources/static/quizapp.png)

## Motivation

I decided to work on this project because I simply love programming, and it brings me so much joy.
I wanted to create it not only to showcase my skills but also to have fun with it.
For me, programming is not just a job; it's a passion. Additionally,
I aim to leverage the tools I'm already familiar with and have on my resume as a testament to my abilities.
Rather than just learning new things through tutorials, I prefer applying them in real projects,
which allows me to learn and grow more effectively.

## Project Overview

The Quiz Application is a RESTful API that offers a range of functionalities centered around quiz management.
Key features of the application encompass user registration, question addition, answer submission, and generating
questions from an external API. Additionally, external modules are integrated, with a future goal of transitioning
to Microservices for recording question-answer events. The API is structured to enable direct communication with the
front-end, facilitated through a RESTful API accessible via the Swagger tool.

## Technologies Used

The Quiz Application is built using the following technologies and tools:  
<img width="50" src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png" alt="Java" title="Java"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png" alt="Spring Boot" title="Spring Boot"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/117207493-49665200-adf4-11eb-808e-a9c0fcc2a0a0.png" alt="Hibernate" title="Hibernate"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/117208740-bfb78400-adf5-11eb-97bb-09072b6bedfc.png" alt="PostgreSQL" title="PostgreSQL"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/183892787-bca94a0e-ffcb-4eeb-8137-e0fc4e446c25.png" alt="Groovy" title="Groovy"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/202540780-999f189c-341a-438e-a7e3-b0838fda6645.png" alt="Spock" title="Spock"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/117533873-484d4480-afef-11eb-9fad-67c8605e3592.png" alt="JUnit" title="JUnit"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/117207330-263ba280-adf4-11eb-9b97-0ac5b40bc3be.png" alt="Docker" title="Docker"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/183868728-b2e11072-00a5-47e2-8a4e-4ebbb2b8c554.png" alt="CI/CD" title="CI/CD"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/192108372-f71d70ac-7ae6-4c0d-8395-51d8870c2ef0.png" alt="Git" title="Git"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/192108374-8da61ba1-99ec-41d7-80b8-fb2f7c0a4948.png" alt="GitHub" title="GitHub"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/186711335-a3729606-5a78-4496-9a36-06efcc74f800.png" alt="Swagger" title="Swagger"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/190229463-87fa862f-ccf0-48da-8023-940d287df610.png" alt="Lombok" title="Lombok"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/192109061-e138ca71-337c-4019-8d42-4792fdaa7128.png" alt="Postman" title="Postman"/>
<img width="50" src="https://user-images.githubusercontent.com/25181517/192108890-200809d1-439c-4e23-90d3-b090cf9a4eea.png" alt="InteliJ" title="InteliJ"/>

- **Java**  
  Java 17 serves as the foundation of this project, where I've harnessed its latest features.
  Notably, records, streams, and method references have been seamlessly integrated to enhance code clarity and
  functionality.
  An emphasis on encapsulation, guided by SOLID principles, underpins the design.
  Additionally, I've implemented prominent design patterns, including the Facade and Builder patterns.
  This concerted approach not only optimizes code structure but also reinforces maintainability and extensibility
  throughout the project.


- **Spring Boot**  
  I've employed various Spring modules to create a comprehensive application framework.
  These include Core, Web, Data, Security, AOP, and Validation.


- **Hibernate**  
  In this project, Hibernate functions as the ORM of choice for validating entities,
  which have been established through Flyway migrations.


- **Spring Security**  
  The app's security is powered by JWT. When users sign up, their passwords are kept safe and used to create tokens for
  access.
  If a token is lost, users can make a new one by confirming their password.
  Additionally, other parts of the app are also locked down to keep things secure.


- **Database: PostgreSQL**  
  The application uses Docker Image of PostgreSQL.


- **Flyway**  
  The application is still a small project and Hibernate would easily handle automatic mapping.
  Altough I want to have a scalability and for that FLyway is really suitable option.


- **Unit Testing: Groovy, Spock**  
  Leveraging Groovy in conjunction with the Spock testing framework addresses a specific challenge encountered in
  Spring Boot application testing. By adhering to encapsulation principles, direct field access is restricted,
  necessitating an alternative approach. Groovy's dynamic nature eliminates the need for traditional getters and
  setters,
  enabling seamless field access in testing. This alignment is particularly advantageous within Domain Driven Design
  contexts,
  upholding the Demeter Law. While this approach warrants caution in production,
  it significantly enhances testing efficiency and maintains code quality.


- **Integration Tests: jUnit**  
  The integration tests I've established primarily assess the status codes returned by endpoints,
  validating their correct operation. These tests operate on a live PostgreSQL database, ensuring accurate
  evaluation of the application's real-world behavior.


- **Architecture: Domain Driven Design**  
  I put in a considerable amount of effort to accurately replicate a real project within its authentic environment.
  As a result, there are times when it might appear somewhat 'overengineered'.
  To be honest, there were simpler approaches available, but my aim was to apply Domain-Driven Design (DDD) principles
  , which led me to take this slightly more elaborate route. Plus, I factored in scalability for the project's future.


- **Docker**  
  Docker was used to package the application into a self-contained image, making it easy to run on different
  environments.
  I also set up other images that work alongside my app for added functionality.


- **Cloud deployment: Heroku**  
  Heroku serves as the deployment platform for this project, triggered automatically upon merging into the main branch.


- **CI/CD: GitHub Actions**  
  GitHub Actions has been configured to facilitate seamless integration and continuous deployment.
  This setup streamlines repository management. Continuous Integration (CI) triggers unit and integration tests with
  every commit.
  On the other hand, Continuous Deployment (CD) is initiated when pull requests are made to the main branch (develop).
  CD entails updating the Docker image on DockerHub and deploying changes to Heroku.


- **Swagger**  
  I utilized Swagger to streamline documentation and facilitate easy exploration of project endpoints. 
  This decision aims for example to simplify frontend implementation by providing an interactive
  Swagger UI documentation accessible at http://localhost:8080/swagger-ui/index.html

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