package com.savethislittle.userinfo.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


@Entity
@Immutable
public class TopExpensesView {

	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id", updatable = false, nullable = false)
//	private Long id;
//	@Version
	@Column(name = "email")
	private String email;

	@Column(name = "category")
	private String category;

	@Column(name = "amount")
	private double amount;
	
	
	
	
	
}
