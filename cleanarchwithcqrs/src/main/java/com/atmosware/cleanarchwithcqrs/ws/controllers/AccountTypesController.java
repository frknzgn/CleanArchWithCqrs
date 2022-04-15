package com.atmosware.cleanarchwithcqrs.ws.controllers;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atmosware.cleanarchwithcqrs.application.features.account.commands.create.CreateAccountTypeCommand;
import com.atmosware.cleanarchwithcqrs.application.features.account.commands.update.UpdateAccountTypeCommand;
import com.atmosware.cleanarchwithcqrs.application.features.account.queries.getall.GetAccountTypesDto;
import com.atmosware.cleanarchwithcqrs.application.features.account.queries.getall.GetAccountTypesQuery;
import com.atmosware.cleanarchwithcqrs.application.features.account.queries.getbyid.GetAccountTypesByIdDto;
import com.atmosware.cleanarchwithcqrs.application.features.account.queries.getbyid.GetAccountTypesByIdQuery;
import com.atmosware.cleanarchwithcqrs.ws.models.CreateAccountTypeModel;
import com.atmosware.cleanarchwithcqrs.ws.models.UpdateAccountTypeModel;

@RestController
@RequestMapping("/accounttypes")
public class AccountTypesController {
	
	private CommandGateway commandGateway;
	private QueryGateway queryGateway;
	
	public AccountTypesController(CommandGateway commandGateway, QueryGateway queryGateway) {

		this.commandGateway = commandGateway;
		this.queryGateway = queryGateway;
		
	}
	
	@PostMapping
	public void createAccountType(@RequestBody CreateAccountTypeModel createAccountTypeModel) {
		
		CreateAccountTypeCommand command = CreateAccountTypeCommand.builder().
										price(createAccountTypeModel.getPrice()).
										accountName(createAccountTypeModel.getAccountName()).
										description(createAccountTypeModel.getDescription()).
										build();
		command.setAccountTypeId(UUID.randomUUID().toString());
		this.commandGateway.sendAndWait(createAccountTypeModel);
		
	}
	
	@PutMapping
	public void updateAccountType(@RequestBody UpdateAccountTypeModel updateAccountTypeModel) {
		
		UpdateAccountTypeCommand command = UpdateAccountTypeCommand.builder().
										accountTypeId(updateAccountTypeModel.getAccountTypeId()).
										price(updateAccountTypeModel.getPrice()).
										accountName(updateAccountTypeModel.getAccountName()).
										description(updateAccountTypeModel.getDescription()).
										build();
		
		this.commandGateway.sendAndWait(updateAccountTypeModel);
		
	}
	
	@GetMapping("/getall")
	public List<GetAccountTypesDto> getAll(){
		
	return this.queryGateway.query(new GetAccountTypesQuery(),
							ResponseTypes.multipleInstancesOf(GetAccountTypesDto.class)).join();
		
	}
	
	@GetMapping("/getbyid")
	public GetAccountTypesByIdDto getAccountTypesById(@RequestBody GetAccountTypesByIdQuery getAccountTypesByIdQuery){
		
	return (GetAccountTypesByIdDto) this.queryGateway.query(getAccountTypesByIdQuery,
							ResponseTypes.instanceOf(GetAccountTypesByIdDto.class)).join();
		
	}
	
}
