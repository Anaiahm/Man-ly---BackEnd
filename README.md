# 🌿 Man*ly Backend

## 📘 Overview

This backend powers the **Man*ly** application by serving as the central data layer and API for the system. It manages users, providers, and care team relationships through a RESTful architecture built with Java and Spring Boot.

The backend acts as the source of truth for the application, ensuring structured, consistent, and persistent data storage using PostgreSQL. By separating frontend and backend responsibilities, the application supports scalability, maintainability, and future feature expansion.

## 🏗 Architecture

The backend follows a **layered architecture pattern**:

- **Controllers** handle incoming HTTP requests  
- **Services** contain business logic and application rules  
- **Repositories** manage database access  
- **DTOs** shape request and response data to maintain separation between internal data models and external API contracts  

This separation of concerns improves maintainability, testability, and clarity across the codebase.

## 🧩 Core Data Model

The system is built around three primary entities:

### 👤 User

Represents an individual using the platform. Users can browse providers and build personalized care teams.

### 🩺 Provider

Represents professionals offering support in specific categories. Providers can belong to multiple users’ care teams.

### 🤝 Care Team

Represents the relationship between users and providers, modeling a many-to-many association within the database.

This relational structure mirrors real-world behavior and required careful modeling using JPA entity relationships.

## 🔄 API Design

The backend exposes RESTful endpoints that allow the frontend to:

- Retrieve providers  
- Add providers to a user’s care team  
- Retrieve a user’s care team  
- Manage user-related data  

Responses are returned in JSON format. The API supports full-stack integration between the deployed frontend and backend.

## 🛠 Tech Stack

- **Language:** Java  
- **Framework:** Spring Boot  
- **ORM:** JPA (Hibernate)  
- **Database:** PostgreSQL  
- **Deployment:** Railway  

Spring Boot provides a structured framework for building RESTful services using established architectural patterns. PostgreSQL enables relational modeling of structured data. Deployment to Railway reinforced real-world configuration practices, including environment variables and production database connections.

## 🧪 Testing

The backend includes test files to validate controller behavior and ensure endpoint reliability. Writing tests strengthened understanding of how backend components interact and how to verify expected behavior in isolation.

## 💥 Challenges & Growth

During development, cross-origin (CORS) issues emerged when connecting the deployed frontend to the backend. While requests functioned correctly in isolated testing environments, browser security policies required explicit backend configuration. Resolving this deepened understanding of HTTP security constraints and full-stack communication.

Additionally, routing inconsistencies caused by duplicate `/api` prefixes between frontend base URLs and backend endpoint mappings required debugging. Fixing this reinforced the importance of consistent API design and environment configuration.

These challenges strengthened debugging skills and increased confidence in managing full-stack systems.
