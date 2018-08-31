package com.savethislittle.userinfo.repository.service;

import java.util.List;
import java.util.Optional;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.entity.SumAmountExpensesMonthYear;
import com.savethislittle.userinfo.repository.entity.SumAmountExpensesYear;
import com.savethislittle.userinfo.repository.entity.User;

public interface UserInfoService {

	public User createUser(final User user);

	public void updateUser(User user);

	public void deleteUserByEmail(String email);

	public User getUserByEmail(String email);

	public boolean checkIfUserExists(String email);

	public List<User> findAll();

	public Expenses createExpense(Expenses expense);

	public void deleteExpense(Long id);

	public Expenses searchExpenseById(Long id);

	public void updateExpense(Expenses expense);

	public Optional<User> getUserById(Long id);

	public List<Expenses> searchExpenseByEmail(String email);

	public List<Expenses> searchExpenseByYearAndEmail(String year, String email);

	public List<Expenses> searchExpenseByMonthAndYearAndEmail(String email, String month, String year);
	
	public List<Expenses> searchExpenseByMonthAndYearAndDayAndEmail(String email, String month, String day, String year);

	public List<Expenses> searchExpenseByMonthAndYearAndEmailAndCategory(String email, String month, String year, String Category);
	
	public List<Expenses> searchExpenseByMonthAndYearAndDayAndEmailAndCategory(String email, String month, String day, String year, String Category);
	
	public List<Expenses> searchExpenseByCategoryAndMail(String category, String email);
	
	public List<Expenses> searchExpenseByCategoryAndMailAndYear(String category, String email, String year);

	public List<SumAmountExpensesYear> getTotalAmountExpensedInCategoryByYear(String email, String year);

	public List<SumAmountExpensesMonthYear> getTotalAmountExpensedInCategoryByMonthAndYear(String email, String month, String year);

}
