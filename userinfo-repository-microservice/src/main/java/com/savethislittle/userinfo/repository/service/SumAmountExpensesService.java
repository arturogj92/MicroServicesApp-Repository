package com.savethislittle.userinfo.repository.service;

import java.util.List;

import com.savethislittle.userinfo.repository.entity.SumAmountExpensesMonthYear;
import com.savethislittle.userinfo.repository.entity.SumAmountExpensesYear;

public interface SumAmountExpensesService {

	public List<SumAmountExpensesYear> getTotalAmountExpensedInCategoryByYear(String email, String year);

	public List<SumAmountExpensesMonthYear> getTotalAmountExpensedInCategoryByMonthAndYear(String email, String month,
			String year);

}
