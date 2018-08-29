package com.savethislittle.userinfo.repository.repository;

import java.util.List;

import com.savethislittle.userinfo.repository.entity.TopExpensesView;

public interface TopExpensesViewCustomRepository {

	
	
	public List<TopExpensesView> searchTopExpenseViewByEmail(String email);
	
}
