package com.atmosware.cleanarchwithcqrs.ws.controllers;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atmosware.cleanarchwithcqrs.application.features.account.commands.create.CreateAccountTypeCommand;
import com.atmosware.cleanarchwithcqrs.ws.models.CreateProductTypeModel;

@RestController
@RequestMapping("/productttypes")
public class ProductTypesController {
	
	private CommandGateway commandGateway;
	private QueryGateway queryGateway;
	
	public ProductTypesController(CommandGateway commandGateway, QueryGateway queryGateway) {

		this.commandGateway = commandGateway;
		this.queryGateway = queryGateway;
		
	}
	
	@PostMapping
	public void createProductType(@RequestBody CreateProductTypeModel createProductTypeModel) {
		
		CreateAccountTypeCommand command = CreateAccountTypeCommand.builder().
										price(createProductTypeModel.getPrice()).
										accountName(createProductTypeModel.getProductName()).
										description(createProductTypeModel.getDescription()).
										build();
		command.setAccountTypeId(UUID.randomUUID().toString());
		this.commandGateway.sendAndWait(createProductTypeModel);
		
	}
	
}