package com.atmosware.cleanarchwithcqrs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounTypes")
public class AccountType {
	
	@Id
	@Column(name = "id")
	private String accountTypeId;
	
	@Column(name = "accountName")
	private String accountName;

	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private double price;
	
}
