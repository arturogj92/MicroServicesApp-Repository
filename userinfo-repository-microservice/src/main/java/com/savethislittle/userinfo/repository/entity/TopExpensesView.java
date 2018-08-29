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


@Table(name = "TOPEXPENSESVIEW")
@Entity
@Immutable
public class TopExpensesView {

	
	

//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id", updatable = false, nullable = false)
//	private Long id;
//	@Version
	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "category")
	private String category;

	@Column(name = "sumamount")
	private double amount;
	
	
	
	
	
}
