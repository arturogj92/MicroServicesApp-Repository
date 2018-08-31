package com.savethislittle.userinfo.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


@Table(name = "sumamountexpensesyear")
@Entity
@Immutable
public class SumAmountExpensesYear {

	
	

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name ="yeardb")
	private String year;
	
	@Column(name = "email")
	private String email;

	@Column(name = "category")
	private String category;

	@Column(name = "sumamount")
	private double amount;
	
	
	
	
	
}
