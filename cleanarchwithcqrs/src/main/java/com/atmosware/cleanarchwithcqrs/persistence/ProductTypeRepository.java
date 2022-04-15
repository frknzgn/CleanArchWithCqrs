package com.atmosware.cleanarchwithcqrs.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atmosware.cleanarchwithcqrs.domain.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, String> {
	
	

}