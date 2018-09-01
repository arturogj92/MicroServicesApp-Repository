package com.savethislittle.userinfo.repository.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Table(name = "EXPENSES")
@Entity
@SequenceGenerator(name = "EXPENSES_SEQ", sequenceName = "expenses_seq")
public class Expenses {

	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	 "EXPENSES_SEQ")
	private Long id;

//	@Size(min = 1, max = 50)
	@Column(name = "TYPE", nullable = false)
	private String type;

	// @Temporal(TemporalType.DATE)
	// @Size(min = 1, max = 50)
//	@Column(name = "DATE", nullable = false)
//	private DateTime date;

	@Column(name = "YEARDB", nullable = false)
	private String year;
	
	@Column(name = "MONTHDB", nullable = false)
	private String month;
	
	@Column(name = "DAYDB", nullable = false)
	private String day;
	
//	@Size(min = 1, max = 50)
	@Column(name = "CATEGORY", nullable = false)
	private String category;

//	@Size(min = 1, max = 50)
	@Column(name = "SUBCATEGORY", nullable = false)
	private String subCategory;

//	@Size(min = 1, max = 200)
	@Column(name = "NOTE", nullable = false)
	private String note;

	@Digits(integer = 6, fraction = 2)
	@Column(name = "AMOUNT", nullable = false)
	private double amount;
	
	// TODO => meter el many to one.
	@Column(name = "email", nullable = false)
	private String email;
	

}
