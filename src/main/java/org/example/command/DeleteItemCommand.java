package org.example.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record DeleteItemCommand(@TargetAggregateIdentifier String itemId) {
}
