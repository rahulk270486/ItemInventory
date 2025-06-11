package org.example.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.example.command.CreateItemCommand;
import org.example.command.DeleteItemCommand;
import org.example.command.UpdateItemCommand;
import org.example.entity.InventoryItem;
import org.example.repo.InventoryItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final CommandGateway commands;
    private final InventoryItemRepository repository;

    public InventoryController(CommandGateway commands, InventoryItemRepository repository) {
        this.commands = commands;
        this.repository = repository;
    }

    @PostMapping("/items")
    public String create(@RequestBody CreateItemRequest req) {
        String id = UUID.randomUUID().toString();
        commands.sendAndWait(new CreateItemCommand(id, req.getName(), req.getQuantity()));
        return id;
    }

    @GetMapping("/items")
    public List<InventoryItem> all() {
        return repository.findAll();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<InventoryItem> byId(@PathVariable String id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Void> update(
            @PathVariable String id,
            @RequestBody UpdateItemRequest req) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        commands.sendAndWait(new UpdateItemCommand(id, req.getName(), req.getQuantity()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        commands.sendAndWait(new DeleteItemCommand(id));
        return ResponseEntity.noContent().build();
    }

    public static class CreateItemRequest {
        private String name;
        private int quantity;

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
    public static class UpdateItemRequest {
        private String name;
        private int quantity;

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
}
