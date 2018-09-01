package com.savethislittle.userinfo.repository.service;

import java.util.List;

import com.savethislittle.userinfo.repository.entity.Expenses;

public interface ExpensesService {

	public Expenses createExpense(Expenses expense);

	public void deleteExpense(Long id);

	public Expenses searchExpenseById(Long id);

	public void updateExpense(Expenses expense);

	public List<Expenses> searchExpenseByEmail(String email);

	public List<Expenses> searchExpenseByYearAndEmail(String year, String email);

	public List<Expenses> searchExpenseByMonthAndYearAndEmail(String email, String month, String year);

	public List<Expenses> searchExpenseByMonthAndYearAndDayAndEmail(String email, String month, String day,
			String year);

	public List<Expenses> searchExpenseByMonthAndYearAndEmailAndCategory(String email, String month, String year,
			String Category);

	public List<Expenses> searchExpenseByMonthAndYearAndDayAndEmailAndCategory(String email, String month, String day,
			String year, String Category);

	public List<Expenses> searchExpenseByCategoryAndMail(String category, String email);

	public List<Expenses> searchExpenseByCategoryAndMailAndYear(String category, String email, String year);

}
