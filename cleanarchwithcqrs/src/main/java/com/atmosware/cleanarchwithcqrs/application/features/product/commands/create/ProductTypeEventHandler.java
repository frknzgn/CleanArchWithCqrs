package com.atmosware.cleanarchwithcqrs.application.features.product.commands.create;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atmosware.cleanarchwithcqrs.domain.ProductType;
import com.atmosware.cleanarchwithcqrs.persistence.ProductTypeRepository;

@Component
public class ProductTypeEventHandler {
	
	private ProductTypeRepository productTypeRepository;
	
	@Autowired
	public ProductTypeEventHandler(ProductTypeRepository productTypeRepository) {
		
		this.productTypeRepository = productTypeRepository;
		
	}
	
	@EventHandler
	public void on(ProductTypeCreatedEvent productTypeCreatedEvent) {
		
		ProductType productType = new ProductType();
		
		BeanUtils.copyProperties(productTypeCreatedEvent, productType);
		
		this.productTypeRepository.save(productType);
		
	}

}