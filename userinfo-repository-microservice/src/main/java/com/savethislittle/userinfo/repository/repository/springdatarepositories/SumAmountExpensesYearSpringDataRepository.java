package com.savethislittle.userinfo.repository.repository.springdatarepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.savethislittle.userinfo.repository.entity.SumAmountExpensesMonthYear;
import com.savethislittle.userinfo.repository.entity.SumAmountExpensesYear;

@Repository
public interface SumAmountExpensesYearSpringDataRepository  extends JpaRepository<SumAmountExpensesYear, String>{

	
	public List<SumAmountExpensesYear> findByEmailAndYear(String email, String year);
	
}
