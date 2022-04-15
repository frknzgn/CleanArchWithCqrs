package com.atmosware.cleanarchwithcqrs.application.features.product.commands.create;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CreateProductTypeAggregate {
	
	@AggregateIdentifier
	private String productTypeId;
	
	private String productName;
	
	private String description;
	
	private double price;
	
	
	public CreateProductTypeAggregate() {
		
	}
	
	@CommandHandler
	public CreateProductTypeAggregate(CreateProductTypeCommand createProductTypeCommand) {
		
		ProductTypeCreatedEvent productTypeCreatedEvent = new ProductTypeCreatedEvent();
		
		BeanUtils.copyProperties(createProductTypeCommand, productTypeCreatedEvent);
		
		AggregateLifecycle.apply(productTypeCreatedEvent);
		
	}
	
	@EventSourcingHandler
	public void on(ProductTypeCreatedEvent productTypeCreatedEvent) {
		
		this.productTypeId = productTypeCreatedEvent.getProductTypeId();
		this.productName = productTypeCreatedEvent.getProductName();
		this.description = productTypeCreatedEvent.getDescription();
		this.price = productTypeCreatedEvent.getPrice();
		
	}
}