package com.atmosware.cleanarchwithcqrs.application.features.account.commands.create;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.atmosware.cleanarchwithcqrs.application.features.account.commands.update.UpdateAccountTypeCommand;

@Aggregate
public class CreateAccountTypeAggregate {
	
	@AggregateIdentifier
	private String accountTypeId;
	
	private String accountName;
	
	private String description;
	
	private double price;
	
	
	public CreateAccountTypeAggregate() {
		
	}
	
	@CommandHandler
	public CreateAccountTypeAggregate(CreateAccountTypeCommand createAccountTypeCommand) {
		
		AccountTypeCreatedEvent accountTypeCreatedEvent = new AccountTypeCreatedEvent();
		
		BeanUtils.copyProperties(createAccountTypeCommand, accountTypeCreatedEvent);
		
		AggregateLifecycle.apply(accountTypeCreatedEvent);
		
	}
	
	@EventSourcingHandler
	public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
		
		this.accountTypeId = accountTypeCreatedEvent.getAccountTypeId();
		this.accountName = accountTypeCreatedEvent.getAccountName();
		this.description = accountTypeCreatedEvent.getDescription();
		this.price = accountTypeCreatedEvent.getPrice();
		
	}
}

