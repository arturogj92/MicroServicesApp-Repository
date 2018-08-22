package com.savethislittle.userinfo.repository.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor

@Table(name = "USER")

@Entity
@SequenceGenerator(name = "USER_SEQ", sequenceName = "user_seq")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	private Long id;

	// @Size(min=1, max=50)
	@Column(name = "USERNAME", nullable = false)
	private String userName;

	// @Size(min=1, max=50)
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	// @Size(min=1, max=50)
	@Column(name = "EMAIL", nullable = false)
	private String email;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ECONOMYINFO_ID", nullable = false)
	private EconomyInfo economyInfo;

	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "user_id")
	// private List<Expenses> expenses = new ArrayList<>();

	// @OneToMany(mappedBy="Expenses")
	// @JoinColumn(name = "EXPENSES_ID", nullable = false)
	// private Expenses expenses;

	// @Formula( value = "CONCAT(firstName, ' ', lastName)")
	// private String fullName;

}
