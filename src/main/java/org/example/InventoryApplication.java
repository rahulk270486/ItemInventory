package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Inventory microservice using Axon Framework.
 *
 * This will bootstrap:
 *   - Spring Boot application context
 *   - Axon components (CommandBus, EventBus, EventStore via JPA)
 *   - JPA repositories for projections
 */
@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }
}
