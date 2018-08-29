package com.savethislittle.userinfo.repository.repository;

import java.util.List;

import com.savethislittle.userinfo.repository.entity.Expenses;

public interface ExpenseCustomRepository {

	
	
	public List<Expenses> searchExpenseByEmail(String email);
	
	public List<Expenses> searchExpenseByCategoryAndMail(String category, String email);
	
	
}
