package com.atmosware.cleanarchwithcqrs.application.features.account.commands.update;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAccountTypeCommand {
	
	@TargetAggregateIdentifier
	private String accountTypeId;
	
	private String accountName;
	
	private String description;
	
	private double price;
	
}