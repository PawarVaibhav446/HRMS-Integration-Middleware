# HRMS-Integration-Middleware
Event-driven HRMS Integration Middleware built with Spring Boot and RabbitMQ. Processes employee lifecycle events via REST APIs and publishes them to a topic exchange for downstream systems (IDAM, CRM, CMS, LMS). Ensures scalable, asynchronous, and loosely coupled architecture with strong validation and clean design.

🧠 Key Features
⚡ Event-driven architecture (no polling)
🔗 RabbitMQ Topic Exchange for dynamic routing
🧩 Loose coupling between systems
✅ Strong validation using DTO + Enum
🚀 Asynchronous processing with 202 Accepted
🔁 Scalable design (easy to add new consumers)
🏗 Clean layered architecture (Controller → DTO → Messaging)

🛠 Tech Stack
Java 17
Spring Boot
RabbitMQ
Maven
Lombok



Event-driven HRMS Integration Middleware built with Spring Boot and RabbitMQ. Processes employee lifecycle events via REST APIs and publishes them to a topic exchange for downstream systems (IDAM, CRM, CMS, LMS). Ensures scalable, asynchronous, and loosely coupled architecture with strong validation and clean design.
