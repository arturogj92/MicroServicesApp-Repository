package com.savethislittle.userinfo.repository.service;

import java.util.List;
import java.util.Optional;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.entity.TopExpensesView;
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

	public List<Expenses> searchExpenseByEmail(String email);
	
	public List<Expenses> searchExpenseByCategoryAndMail(String category, String email);
	
	public Expenses searchExpenseById(Long id);
	
	public void updateExpense(Expenses expense);
	
	public Optional<User> getUserById(Long id);
	
	public List<TopExpensesView> getTopExpensesViewByEmail(String email);
	
	public List<TopExpensesView> findByEmail(String email);


	

}
