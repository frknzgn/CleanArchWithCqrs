package com.atmosware.cleanarchwithcqrs.application.features.product.commands.create;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductTypeCommand {
	
	@TargetAggregateIdentifier
	private String productTypeId;
	
	private String productName;
	
	private String description;
	
	private double price;
	
}