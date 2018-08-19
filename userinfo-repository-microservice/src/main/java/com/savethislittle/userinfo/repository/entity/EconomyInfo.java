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

@Table(name = "ECONOMYINFO")
@Entity
@SequenceGenerator(name = "ECONOMYINFO_SEQ", sequenceName = "economyinfo_seq")
public class EconomyInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ECONOMYINFO_SEQ")
	private Long id;

	@Digits(integer=6, fraction=2)
	@Column(name = "MONTHLYEARNING", nullable = false)
	private double monthlyEarning;

	@Digits(integer=6, fraction=2)
	@Column(name = "CURRENTMONEY", nullable = false)
	private double currentMoney;

	
	

	// @Formula( value = "CONCAT(firstName, ' ', lastName)")
	// private String fullName;

}
