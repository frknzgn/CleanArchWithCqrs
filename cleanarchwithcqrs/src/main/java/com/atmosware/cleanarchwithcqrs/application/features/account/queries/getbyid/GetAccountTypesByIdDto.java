package com.atmosware.cleanarchwithcqrs.application.features.account.queries.getbyid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAccountTypesByIdDto {
	
	
	private String accountTypeId;
	
	private String accountName;

	private String description;
	
	private double price;
	
}