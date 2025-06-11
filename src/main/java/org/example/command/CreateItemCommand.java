package org.example.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record CreateItemCommand(@TargetAggregateIdentifier String itemId, String name, int initialQuantity) {

    @Override
    public String itemId() {
        return itemId;
    }
}
