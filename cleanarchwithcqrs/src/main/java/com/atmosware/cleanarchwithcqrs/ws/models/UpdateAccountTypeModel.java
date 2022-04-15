package com.atmosware.cleanarchwithcqrs.ws.models;

import lombok.Data;

@Data
public class UpdateAccountTypeModel {
	
	private String accountTypeId;
	
	private String accountName;
	
	private String description;
	
	private double price;
	
}