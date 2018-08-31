package com.savethislittle.userinfo.repository.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.entity.SumAmountExpensesMonthYear;
import com.savethislittle.userinfo.repository.entity.SumAmountExpensesYear;
import com.savethislittle.userinfo.repository.entity.User;
import com.savethislittle.userinfo.repository.exception.UserInfoRepositoryException;
import com.savethislittle.userinfo.repository.repository.ExpenseCustomRepository;
import com.savethislittle.userinfo.repository.repository.SumAmountExpensesMonthYearCustomRepository;
import com.savethislittle.userinfo.repository.repository.UserInfoCustomRepository;
import com.savethislittle.userinfo.repository.repository.springdatarepositories.ExpenseSpringDataRepository;
import com.savethislittle.userinfo.repository.repository.springdatarepositories.SumAmountExpensesMonthYearSpringDataRepository;
import com.savethislittle.userinfo.repository.repository.springdatarepositories.SumAmountExpensesYearSpringDataRepository;
import com.savethislittle.userinfo.repository.repository.springdatarepositories.UserInfoSpringDataRepository;
import com.savethislittle.userinfo.repository.service.UserInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoSpringDataRepository userInfoSpringDataRepository;
	private UserInfoCustomRepository userInfoCustomRepository;
	
	private SumAmountExpensesMonthYearSpringDataRepository sumAmountExpensesMonthYearSpringDataRepository;
	private SumAmountExpensesMonthYearCustomRepository sumAmountExpensesMonthYearCustomRepository;
	
	private SumAmountExpensesYearSpringDataRepository sumAmountExpensesYearSpringDataRepository;
	
	private ExpenseSpringDataRepository expensesSpringDataRepository;
	private ExpenseCustomRepository expenseCustomRepository;
	
	
	

	@Override
	public User createUser(final User user) {
		if (userInfoCustomRepository.checkIfUserExist(user.getEmail()) == false) {
			return userInfoSpringDataRepository.save(user);
		} else
			log.error("ACTION: createUser ERROR => {}", "User ** " + user.getEmail() + " ** not created");
		throw new UserInfoRepositoryException("The user already exists");
	}

	@Override
	public Expenses createExpense(Expenses expense) {
		expensesSpringDataRepository.save(expense);
		return null;
	}

	@Override
	public Expenses searchExpenseById(Long id) {
		Optional<Expenses> expenseOptional = expensesSpringDataRepository.findById(id);
		if (!expenseOptional.isPresent()) {
			log.error("ACTION: searchExpenseById ERROR => {}", "Expense ** " + id + " ** not found");
			throw new UserInfoRepositoryException("The expense doesn't exists");
		}
		return expenseOptional.get();
	}

	@Override
	public void deleteExpense(Long id) {
		searchExpenseById(id);
		expensesSpringDataRepository.deleteById(id);
	}

	@Override
	public void updateUser(User user) {
		Optional<User> findById = userInfoSpringDataRepository.findById(user.getId());
		if (findById.isPresent()) {

			List<User> userAux = userInfoCustomRepository.findUserByEmail(user.getEmail());

			// Double check to see if the user email belongs to the user to be updated.
			if (!userAux.isEmpty()) {
				if (userAux.get(0).getEmail().toString() != findById.get().getEmail().toString()) {
					log.error("ACTION: updateUser ERROR => {}", "User email " + user.getEmail() + " is in use");
					throw new UserInfoRepositoryException("User email is in use");
				}
			}
			userInfoSpringDataRepository.save(user);
		}

		else {
			log.error("ACTION: updateUser ERROR => {}", "User ID " + user.getId() + " is not asociated to any user");
			throw new UserInfoRepositoryException("The id is not asociated to any user");
		}

	}

	@Override
	public void updateExpense(Expenses expense) {
		searchExpenseById(expense.getId());
		expensesSpringDataRepository.save(expense);
	}

	@Override
	public void deleteUserByEmail(String email) {
		User user = getUserByEmail(email);
		userInfoSpringDataRepository.delete(user);
	}

	@Override
	public List<User> findAll() {
		List<User> userList = userInfoSpringDataRepository.findAll();
		return userList;
	}

	@Override
	public User getUserByEmail(String email) {
		List<User> userList = userInfoCustomRepository.findUserByEmail(email);

		if (!(userList.isEmpty())) {
			return userList.get(0);
		}

		else {
			log.error("ACTION: getUserByEmail ERROR =>  {}", "User doesn't exists");
			throw new UserInfoRepositoryException("User doesn't exists");
		}
	}

	@Override
	public List<Expenses> searchExpenseByEmail(String email) {
		List<Expenses> expenses = expenseCustomRepository.searchExpenseByEmail(email);
		if (expenses.isEmpty()) {
			log.error("ACTION: findExpensesByEmail ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated");

		}

		return expenses;
	}

	@Override
	public List<Expenses> searchExpenseByCategoryAndMail(String category, String email) {
		List<Expenses> expenses = expenseCustomRepository.searchExpenseByCategoryAndEMail(category, email);
		if (expenses.isEmpty()) {
			log.error("ACTION: searchExpenseByCategoryAndMail ERROR => expenses.size(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses of that category asociated ");

		}

		return expenses;
	}
	
	
	
	@Override
	public List<Expenses> searchExpenseByCategoryAndMailAndYear(String category, String email, String year) {
		List<Expenses> expenses = expensesSpringDataRepository.findByCategoryAndEmailAndYear(category, email, year);
		if (expenses.isEmpty()) {
			log.error("ACTION: searchExpenseByCategoryAndMail ERROR => expenses.size(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses of that category asociated ");

		}

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

	@Override
	public Optional<User> getUserById(Long id) {
		Optional<User> user1 = userInfoSpringDataRepository.findById(id);
		if (user1.isPresent()) {
			return user1;
		}

		return null;

	}


	@Override
	public List<SumAmountExpensesMonthYear> getTotalAmountExpensedInCategoryByMonthAndYear(String email, String month, String year) {
		List<SumAmountExpensesMonthYear> expenses = sumAmountExpensesMonthYearSpringDataRepository.findByEmailAndMonthAndYear(email, month, year);
		if (expenses.isEmpty()) {
			log.error("ACTION: getTotalAmountExpensedInCategoryByMonthAndYear ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated");
		}

		return expenses;
	}

	@Override
	public List<SumAmountExpensesYear> getTotalAmountExpensedInCategoryByYear(String email, String year) {
		List<SumAmountExpensesYear> expenses = sumAmountExpensesYearSpringDataRepository.findByEmailAndYear(email, year);
		if (expenses.isEmpty()) {
			log.error("ACTION: getTotalAmountExpensedInCategoryByYear ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated");
		}

		return expenses;
	}



	@Override
	public List<Expenses> searchExpenseByMonthAndYearAndEmail(String email, String month, String year) {
		List<Expenses> expenses = expensesSpringDataRepository.findByMonthAndYearAndEmail(month, year, email);
		if (expenses.isEmpty()) {
			log.error("ACTION: searchExpenseByMonthAndYearAndEmail ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated");

		}

		return expenses;
	}
	
	
	@Override
	public List<Expenses> searchExpenseByMonthAndYearAndDayAndEmail(String email, String month, String day, String year) {
		List<Expenses> expenses = expensesSpringDataRepository.findByMonthAndYearAndDayAndEmail(month, year, day, email);
		if (expenses.isEmpty()) {
			log.error("ACTION: searchExpenseByMonthAndYearAndDayAndEmail ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated");

		}

		return expenses;
	}
	
	@Override
	public List<Expenses> searchExpenseByMonthAndYearAndEmailAndCategory(String email, String month, String year, String category) {
		List<Expenses> expenses = expensesSpringDataRepository.findByMonthAndYearAndEmailAndCategory(month, year, email, category);
		if (expenses.isEmpty()) {
			log.error("ACTION: searchExpenseByMonthAndYearAndEmailAndCategory ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated");

		}

		return expenses;
	}
	
	
	public List<Expenses> searchExpenseByMonthAndYearAndDayAndEmailAndCategory(String email, String month, String day, String year, String category) {
		List<Expenses> expenses = expensesSpringDataRepository.findByMonthAndYearAndDayAndEmailAndCategory(month, year, day, email, category);
		if (expenses.isEmpty()) {
			log.error("ACTION: searchExpenseByMonthAndYearAndDayAndEmailAndCategory ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated");

		}

		return expenses;
	}

	@Override
	public List<Expenses> searchExpenseByYearAndEmail(String email, String year) {
		List<Expenses> expenses = expensesSpringDataRepository.findByYearAndEmail(year, email);
		if (expenses.isEmpty()) {
			log.error("ACTION: findExpensesByEmail ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated THIS YEAR");

		}

		return expenses;
	}


}
