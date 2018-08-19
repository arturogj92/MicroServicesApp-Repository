package com.savethislittle.userinfo.repository.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.entity.User;
import com.savethislittle.userinfo.repository.repository.ExpenseCustomRepository;
import com.savethislittle.userinfo.repository.repository.UserExpenseSpringDataRepository;
import com.savethislittle.userinfo.repository.repository.UserInfoSpringDataRepository;
import com.savethislittle.userinfo.repository.service.UserInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoSpringDataRepository userInfoSpringDataRepository;
	private UserExpenseSpringDataRepository userExpensesSpringDataRepository;
	private ExpenseCustomRepository expenseCustomRepository;
	
	@Override
	public User createUser(final User user) {
		// TODO Auto-generated method stub
//		return userInfoSpringDataRepository.save(user);
		userInfoSpringDataRepository.save(user);
		return null;
	}

	
	//mirar para insertar lista de gastos
	public Expenses createExpense(Expenses expense) {
		userExpensesSpringDataRepository.save(expense);
		return null;
	}
	

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Expenses> searchExpenseById(Long id) {
		// TODO Auto-generated method stub
		System.out.println("AGJ -> ESTOY AQUI");
		log.info("searchExpenseById dataIn => data: {}", id);
		List<Expenses> expenses = expenseCustomRepository.searchExpenseById(id);
		//log.info("simpleSearch dataOut => employees.size(): {}", expenses.size());
		return expenses;
	}

}
