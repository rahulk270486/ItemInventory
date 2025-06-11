package org.example.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record UpdateItemCommand(@TargetAggregateIdentifier String itemId, String name, int initialQuantity) {
}
