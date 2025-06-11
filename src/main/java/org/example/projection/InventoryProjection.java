package org.example.projection;

import org.axonframework.eventhandling.EventHandler;
import org.example.entity.InventoryItem;
import org.example.event.ItemCreatedEvent;
import org.example.event.ItemDeletedEvent;
import org.example.event.ItemUpdatedEvent;
import org.example.repo.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryProjection {

    @Autowired
    private InventoryItemRepository repository;

    @EventHandler
    public void on(ItemCreatedEvent evt) {
        InventoryItem item = new InventoryItem(evt.itemId(), evt.name(), evt.quantity());
        repository.save(item);
    }

    @EventHandler
    public void on(ItemUpdatedEvent evt) {
        repository.findById(evt.getItemId()).ifPresent(item -> {
            item.setName(evt.getName());
            item.setQuantity(evt.getQuantity());
            repository.save(item);
        });
    }

    @EventHandler
    public void on(ItemDeletedEvent evt) {
        repository.deleteById(evt.getItemId());
    }
}
