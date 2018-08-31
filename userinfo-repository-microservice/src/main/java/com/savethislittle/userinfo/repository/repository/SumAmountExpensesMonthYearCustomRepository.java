package com.savethislittle.userinfo.repository.repository;

import java.util.List;

import com.savethislittle.userinfo.repository.entity.SumAmountExpensesMonthYear;

public interface SumAmountExpensesMonthYearCustomRepository {

	
	
	public List<SumAmountExpensesMonthYear> searchTopExpenseViewByEmail(String email);
	
}
