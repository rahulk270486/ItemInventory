package org.example.event;

public class ItemDeletedEvent {
    private final String itemId;

    public ItemDeletedEvent(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }
}
