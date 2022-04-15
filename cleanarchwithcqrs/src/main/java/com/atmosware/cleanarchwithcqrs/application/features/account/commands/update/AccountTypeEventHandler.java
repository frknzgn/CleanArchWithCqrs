package com.atmosware.cleanarchwithcqrs.application.features.account.commands.update;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atmosware.cleanarchwithcqrs.domain.AccountType;
import com.atmosware.cleanarchwithcqrs.persistence.AccountTypeRepository;

@Component
	public class AccountTypeEventHandler {
		
		private AccountTypeRepository accountTypeRepository;
		
		@Autowired
		public AccountTypeEventHandler(AccountTypeRepository accountTypeRepository) {
			
			this.accountTypeRepository = accountTypeRepository;
			
		}
		
		@EventHandler
		public void on(AccountTypeUpdatedEvent accountTypeUpdatedEvent) {
			
			AccountType accountType = new AccountType();
			
			BeanUtils.copyProperties(accountTypeUpdatedEvent, accountType);
			
			this.accountTypeRepository.save(accountType);
			
		}

	}

