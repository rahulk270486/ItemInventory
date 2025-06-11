# CQRS with Event Sourcing in Java Microservices

This project demonstrates how to implement **Command Query Responsibility Segregation (CQRS)** combined with **Event Sourcing** using Spring Boot and the Axon Framework within a microservices architecture.

---

## Why CQRS + Event Sourcing?

- **Scalability & performance**: Separates read/write models to optimize each independently.
- **Auditability**: Every state change is captured as an immutable event, allowing full traceability and state reconstruction.
- **Domain-driven design synergy**: Naturally aligns with aggregates, commands, and events as part of DDD practices.

> “CQRS combined with Event Sourcing is a powerful architectural approach for microservices that demand scalability, traceability, and flexibility.”

---

## Features

- Clean separation of **Command** and **Query** responsibilities.
- **Axon Framework** for dispatching commands, handling events, and managing aggregates.
- **Event Store** persistence for tracking all changes as domain events.
- **Query Model** auto-updated via event handlers, optimized for fast and flexible reads.
- Sample implementation includes:
  - Command and Event classes
  - Aggregate root
  - Event handler projections
  - REST endpoints

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- Axon Server (optional: can run with in-memory event store)

### Clone and Build

```bash
git clone https://github.com/rahulk270486/ItemInventory.git
cd ItemInventory

# Build the project
./mvn clean install

# start the application
./mvn spring-boot:run
```
## Related Blog Post
This code example is based on the article:
[Command Query Responsibility Segregation (CQRS) with Event Sourcing in Java Microservices](https://medium.com/@27.rahul.k/command-query-responsibility-segregation-cqrs-with-event-sourcing-in-java-microservices-43658025d336)

Head over to the post for a full walkthrough and explanation of the design choices behind this implementation.

## 👤 Author

**Rahul K**  
Senior Technical Architect | Java • Spring Boot • Kafka • Cloud

🔗 [LinkedIn](https://www.linkedin.com/in/rahul-kumar-9754b919/)
💻 [GitHub](https://github.com/rahulk270486)

