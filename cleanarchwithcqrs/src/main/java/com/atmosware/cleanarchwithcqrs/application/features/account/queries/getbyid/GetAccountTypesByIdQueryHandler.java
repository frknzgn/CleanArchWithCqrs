package com.atmosware.cleanarchwithcqrs.application.features.account.queries.getbyid;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atmosware.cleanarchwithcqrs.domain.AccountType;
import com.atmosware.cleanarchwithcqrs.persistence.AccountTypeRepository;

public class GetAccountTypesByIdQueryHandler {

	@Component
	public class GetAccountTypesQueryHandler {
		
		private AccountTypeRepository accountTypeRepository;

		@Autowired
		public GetAccountTypesQueryHandler(AccountTypeRepository accountTypeRepository) {
			
			this.accountTypeRepository = accountTypeRepository;
			
		}
		
		@QueryHandler
		public GetAccountTypesByIdDto getAccountTypesById(GetAccountTypesByIdQuery getAccountTypesByIdQuery){
			
			GetAccountTypesByIdDto result = new GetAccountTypesByIdDto();
			
			AccountType accountType = this.accountTypeRepository.getByAccountTypeId(getAccountTypesByIdQuery.getAccountTypeId());
			
			BeanUtils.copyProperties(accountType, result);
		
			return result;
		
		}

	}
}
