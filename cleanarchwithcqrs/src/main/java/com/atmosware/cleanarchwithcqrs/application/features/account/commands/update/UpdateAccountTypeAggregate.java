package com.atmosware.cleanarchwithcqrs.application.features.account.commands.update;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UpdateAccountTypeAggregate {
	
	@AggregateIdentifier
	private String accountTypeId;
	
	private String accountName;
	
	private String description;
	
	private double price;
	
	
	public UpdateAccountTypeAggregate() {
		
	}
	
	@CommandHandler
	public UpdateAccountTypeAggregate(UpdateAccountTypeCommand updateAccountTypeCommand) {
		
		AccountTypeUpdatedEvent accountTypeUpdatedEvent = new AccountTypeUpdatedEvent();
		
		BeanUtils.copyProperties(updateAccountTypeCommand, accountTypeUpdatedEvent);
		
		AggregateLifecycle.apply(accountTypeUpdatedEvent);
		
	}
	
	@EventSourcingHandler
	public void on(AccountTypeUpdatedEvent accountTypeUpdatedEvent) {
		
		this.accountTypeId = accountTypeUpdatedEvent.getAccountTypeId();
		this.accountName = accountTypeUpdatedEvent.getAccountName();
		this.description = accountTypeUpdatedEvent.getDescription();
		this.price = accountTypeUpdatedEvent.getPrice();
		
	}
}