package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InventoryItem {
    @Id
    private String itemId;
    private String name;
    private int quantity;

    public InventoryItem(){}

    public InventoryItem(String itemId, String name, int quantity) {
        this.itemId=itemId;
        this.name=name;
        this.quantity=quantity;
    }


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
