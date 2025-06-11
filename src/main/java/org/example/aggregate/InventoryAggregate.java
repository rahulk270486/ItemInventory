package org.example.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.CommandHandlerInterceptor;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.command.CreateItemCommand;
import org.example.command.DeleteItemCommand;
import org.example.command.UpdateItemCommand;
import org.example.event.ItemCreatedEvent;
import org.example.event.ItemDeletedEvent;
import org.example.event.ItemUpdatedEvent;

@Aggregate
public class InventoryAggregate {
    @AggregateIdentifier
    private String itemId;
    private String name;
    private int quantity;

    protected InventoryAggregate() {}

    @CommandHandlerInterceptor
    public void interceptor(Object obj){
        System.out.println(obj);
    }

    @CommandHandler
    public InventoryAggregate(CreateItemCommand cmd) {
        AggregateLifecycle.apply(new ItemCreatedEvent(cmd.itemId(), cmd.name(), cmd.initialQuantity()));
    }

    @CommandHandler
    public void handle(UpdateItemCommand cmd) {
        AggregateLifecycle.apply(new ItemUpdatedEvent(cmd.itemId(), cmd.name(), cmd.initialQuantity()));
    }

    @CommandHandler
    public void handle(DeleteItemCommand cmd) {
        AggregateLifecycle.apply(new ItemDeletedEvent(cmd.itemId()));
    }

    @EventSourcingHandler
    public void on(ItemCreatedEvent evt) {
        this.itemId = evt.itemId();
        this.name = evt.name();
        this.quantity = evt.quantity();
    }

    @EventSourcingHandler
    public void on(ItemUpdatedEvent evt) {
        this.name = evt.getName();
        this.quantity = evt.getQuantity();
    }

    @EventSourcingHandler
    public void on(ItemDeletedEvent evt) {
        // mark aggregate as deleted
        AggregateLifecycle.markDeleted();
    }
}
