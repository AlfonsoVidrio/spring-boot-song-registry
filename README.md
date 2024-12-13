# Song Registry

## Description

Spring Boot application with JPA and PostgreSQL for managing singers and their songs.

---

## Features

- Register new singers with basic information.  
- Register new songs and link them to an existing singer.  
- Search for songs by singer's name.  
- PostgreSQL database with JPA support.  

---

## Technologies Used

- [Spring Boot](https://spring.io/projects/spring-boot)  
- [JPA (Java Persistence API)](https://spring.io/projects/spring-data-jpa)  
- [PostgreSQL](https://www.postgresql.org/)  

---

## Installation

1. Clone the repository:

```bash
git clone <repository-url>
```
2. Set up the PostgreSQL database in your local environment.
3. Add your database credentials to the application.properties file located at src/main/resources/

### Example configuration

```bash
spring.application.name=Song Registry

spring.datasource.url=jdbc:postgresql://${DB_HOST:localhost}/song_registry
spring.datasource.username=${DB_USER:your_username}
spring.datasource.password=${DB_PASSWORD:your_password}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true
```
