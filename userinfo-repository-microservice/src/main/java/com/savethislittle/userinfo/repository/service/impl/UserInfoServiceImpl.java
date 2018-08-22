package com.savethislittle.userinfo.repository.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.entity.User;
import com.savethislittle.userinfo.repository.exception.UserInfoRepositoryException;
import com.savethislittle.userinfo.repository.repository.ExpenseCustomRepository;
import com.savethislittle.userinfo.repository.repository.UserExpenseSpringDataRepository;
import com.savethislittle.userinfo.repository.repository.UserInfoCustomRepository;
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
	private UserInfoCustomRepository userInfoCustomRepository;

	@Override
	public User createUser(final User user) {
		// TODO Auto-generated method stub
		if (userInfoCustomRepository.checkIfUserExist(user.getEmail()) == false) {
			return userInfoSpringDataRepository.save(user);
		}
		else
			throw new UserInfoRepositoryException("The user already exists");
	}

	// mirar para insertar lista de gastos
	@Override
	public Expenses createExpense(Expenses expense) {
		userExpensesSpringDataRepository.save(expense);
		return null;
	}
	
	@Override
	public Expenses searchExpenseById(Long id) {
		// TODO cambiar la excepcion de userinforepository a expenserepository
		Optional<Expenses> expenseOptional = userExpensesSpringDataRepository.findById(id);
		if(!expenseOptional.isPresent()) {
		throw new UserInfoRepositoryException("The expense not exist");
	}
		return expenseOptional.get();
	}
	
	@Override
	public void deleteExpense(Long id) {
		// TODO Auto-generated method stub
		searchExpenseById(id);
		userExpensesSpringDataRepository.deleteById(id);
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
	public List<Expenses> searchExpenseByUser(String email) {
		// TODO Auto-generated method stub
		log.info("searchExpenseById dataIn => data: {}", email);
		List<Expenses> expenses = expenseCustomRepository.searchExpenseByUser(email);
		if (expenses.isEmpty()) {
			System.out.println("no existe lcooooo");
			throw new UserInfoRepositoryException("The user not exist");
		}
		// log.info("simpleSearch dataOut => employees.size(): {}", expenses.size());
		return expenses;
	}

	@Override
	public boolean checkIfUserExists(String email) {
		// TODO Auto-generated method stub

		Boolean userCheckExists = userInfoCustomRepository.checkIfUserExist(email);

		if (userCheckExists == true) {
			throw new UserInfoRepositoryException("The user already exists");
		}

		return userCheckExists;

	}






}
