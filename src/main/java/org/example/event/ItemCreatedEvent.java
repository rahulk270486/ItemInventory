package org.example.event;

public record ItemCreatedEvent(String itemId, String name, int quantity) {
}
