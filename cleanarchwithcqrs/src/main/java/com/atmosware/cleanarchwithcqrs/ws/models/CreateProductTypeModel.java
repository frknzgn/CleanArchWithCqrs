package com.atmosware.cleanarchwithcqrs.ws.models;

import lombok.Data;

@Data
public class CreateProductTypeModel {
		
	private String productName;
	
	private String description;
	
	private double price;
	
}