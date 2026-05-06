# User Auth Service

A production-style Spring Boot authentication web application with PostgreSQL, Flyway migrations, Docker support, and Render deployment.

The project demonstrates how user registration, login, password hashing, database persistence, environment-based configuration, and cloud deployment can be combined in a clean backend application.

## Live Demo

Public deployment:

https://authservice-gjvh.onrender.com/login

Available pages:

- `/login`
- `/signup`
- `/`
- `/actuator/health`

## Project Goal

The goal of this project is to provide a reusable authentication foundation for larger web applications.

It focuses on:

- User registration
- Form-based login with Spring Security
- Secure password hashing with BCrypt
- Role-based user model
- PostgreSQL persistence
- Flyway database migrations
- Docker-based local setup
- Render cloud deployment
- Environment-based production configuration

## Architecture

```text
Client Browser
      ↓
Spring MVC Controller
      ↓
Spring Security
      ↓
Service Layer
      ↓
Spring Data JPA / Hibernate
      ↓
PostgreSQL