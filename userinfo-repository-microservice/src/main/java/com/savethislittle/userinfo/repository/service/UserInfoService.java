package com.savethislittle.userinfo.repository.service;

import java.util.List;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.entity.User;

public interface UserInfoService {

	public User createUser(final User user);

	public void updateUser(User user);

	public void deleteUserByEmail(String email);
	
	public User findUserByEmail(String email);
	
	public boolean checkIfUserExists(String email);

	public List<User> findAll();

	public Expenses createExpense(Expenses expense);
	
	public void deleteExpense(Long id);

	public List<Expenses> searchExpenseByUser(String email);
	
	public Expenses searchExpenseById(Long id);
	
	public void updateExpense(Expenses expense);


	

}
