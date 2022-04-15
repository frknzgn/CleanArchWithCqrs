package com.atmosware.cleanarchwithcqrs.application.features.product.commands.create;

import lombok.Data;

@Data
public class ProductTypeCreatedEvent {
	
	private String productTypeId;
	
	private String productName;
	
	private String description;
	
	private double price;
	
}