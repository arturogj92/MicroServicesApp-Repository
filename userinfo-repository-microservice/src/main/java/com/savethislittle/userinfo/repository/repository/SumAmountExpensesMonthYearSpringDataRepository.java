package com.savethislittle.userinfo.repository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.savethislittle.userinfo.repository.entity.SumAmountExpensesMonthYear;

@Repository
public interface SumAmountExpensesMonthYearSpringDataRepository extends JpaRepository<SumAmountExpensesMonthYear, String> {

	public List<SumAmountExpensesMonthYear> findByEmail(String email);
	
	public List<SumAmountExpensesMonthYear> findByEmailAndMonthAndYear(String email, String month, String year);

	public List<SumAmountExpensesMonthYear> findByEmailAndYear(String email, String year);
}
