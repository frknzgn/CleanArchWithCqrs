package com.atmosware.cleanarchwithcqrs.application.features.account.commands.update;

import lombok.Data;

@Data
public class AccountTypeUpdatedEvent {
	
	private String accountTypeId;
	
	private String accountName;
	
	private String description;
	
	private double price;
	
}