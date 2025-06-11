package org.example.event;

public class ItemUpdatedEvent {
    private final String itemId;
    private final String name;
    private final int quantity;

    public ItemUpdatedEvent(String itemId, String name, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
