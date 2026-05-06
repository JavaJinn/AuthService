# 🔐 User Auth Service

A production-style authentication service built with Spring Boot, PostgreSQL, Docker, and Render deployment.

This project demonstrates secure authentication architecture, environment-based configuration management, containerization, database migrations, and cloud deployment practices.

---

# 🚀 Live Demo

## Public Deployment

https://authservice-gjvh.onrender.com/login

## Available Pages

### Login

```text
/login
```

### Signup

```text
/signup
```

---

# 📌 Project Goal

The goal of this project was to build a reusable authentication service that can be integrated into larger applications or microservice environments.

The service focuses on:

* User registration
* Secure login authentication
* Session/security handling
* Environment-based configuration
* Database persistence
* Production deployment
* Docker containerization

---

# 🧠 What I Learned

During this project I learned:

* Spring Boot architecture and dependency injection
* Authentication and authorization concepts
* Environment variable management
* Cloud deployment with Render
* PostgreSQL integration
* Flyway database migrations
* Docker-based application packaging
* Production debugging and deployment troubleshooting
* Test profile separation using H2

---

# 🏗️ Architecture

```text
Client Browser
      ↓
Spring Boot Web Application
      ↓
Spring Security
      ↓
JPA / Hibernate
      ↓
PostgreSQL Database
```

---

# 🔐 Features

## Authentication

* User signup
* User login
* Password hashing
* Spring Security integration
* Remember-me functionality
* Protected routes

## Infrastructure

* PostgreSQL database
* Flyway migrations
* Docker support
* Render cloud deployment
* Environment variable configuration
* Production profile support

## Development

* Maven build system
* H2 test configuration
* Layered architecture
* Repository pattern

---

# ⚙️ Tech Stack

| Category         | Technology      |
| ---------------- | --------------- |
| Backend          | Java 21         |
| Framework        | Spring Boot 4   |
| Security         | Spring Security |
| Database         | PostgreSQL      |
| ORM              | Hibernate / JPA |
| Migration        | Flyway          |
| Build Tool       | Maven           |
| Containerization | Docker          |
| Deployment       | Render          |
| Testing          | JUnit + H2      |

---

# 📂 Project Structure

```text
src/
 ├── main/
 │    ├── java/
 │    └── resources/
 │
 └── test/
      └── java/
```

### Main Layers

| Layer      | Responsibility                 |
| ---------- | ------------------------------ |
| Controller | Handles HTTP requests          |
| Service    | Business logic                 |
| Repository | Database access                |
| Entity     | Database models                |
| Security   | Authentication & authorization |

---

# 🌍 Environment Variables

The application uses environment variables for secure production deployment.

## Required Variables

```env
SPRING_PROFILES_ACTIVE=prod

DB_URL=jdbc:postgresql://HOST:5432/DATABASE
DB_USERNAME=YOUR_USERNAME
DB_PASSWORD=YOUR_PASSWORD

REMEMBER_ME_KEY=your-secret-key
JWT_SECRET=your-jwt-secret

PORT=10000
SERVER_PORT=10000
```

---

# 🐳 Docker Support

The project includes Docker support for portable deployments.

## Build Docker Image

```bash
docker build -t auth-service .
```

## Run Container

```bash
docker run -p 8080:8080 auth-service
```

---

# ▶️ Running Locally

## Clone Repository

```bash
git clone YOUR_REPOSITORY_URL
```

## Build Application

```bash
./mvnw clean install
```

## Start Application

```bash
java -jar target/app.jar
```

---

# 🧪 Testing

## Test Profile

The project uses a dedicated test profile with an in-memory H2 database.

This prevents tests from depending on production infrastructure.

## Run Tests

```bash
./mvnw test
```

---

# 🛠️ Deployment

The application is deployed on Render using:

* Docker-based deployment
* Managed PostgreSQL database
* Environment variables
* Production profile configuration

---

# 🔒 Security Considerations

The project currently includes:

* Password hashing
* Environment-based secret management
* Secure database credentials
* Session authentication
* Spring Security configuration

---

# 📈 Planned Improvements

## High Priority

* JWT access + refresh token flow
* Role-based authorization (ADMIN / USER)
* Swagger/OpenAPI documentation
* Integration tests
* API rate limiting
* Structured logging
* CI/CD pipeline

## Future Ideas

* OAuth2 / Google Login
* Email verification
* Password reset flow
* Redis caching
* Monitoring dashboards
* Multi-factor authentication

---

# 🧪 Recommended Manual Test Flow

## 1. Open Signup Page

```text
/signup
```

## 2. Create User

Use:

```text
Username: demo_user
Password: TestPassword123
```

## 3. Login

```text
/login
```

## 4. Access Protected Pages

Verify that unauthorized users cannot access protected routes.

---

# 💬 Interview Talking Points

## Why Spring Boot?

> I chose Spring Boot because it provides production-grade tooling, dependency injection, security integration, and strong ecosystem support for backend development.

## Why PostgreSQL?

> PostgreSQL is reliable, scalable, and widely used in production systems.

## Why Environment Variables?

> Secrets and infrastructure configuration should never be hardcoded into source code.

## Why H2 For Tests?

> It isolates tests from production infrastructure and makes automated testing faster and reproducible.

## What Was Challenging?

> Production deployment, database configuration, Flyway migrations, and cloud environment troubleshooting.

---

# 📜 License

This project is intended for educational and portfolio purposes.
