package com.savethislittle.userinfo.repository.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.exception.UserInfoRepositoryException;
import com.savethislittle.userinfo.repository.repository.customrepositories.ExpenseCustomRepository;
import com.savethislittle.userinfo.repository.repository.springdatarepositories.ExpenseSpringDataRepository;
import com.savethislittle.userinfo.repository.service.ExpensesService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class ExpensesServiceImpl implements ExpensesService {

	private ExpenseSpringDataRepository expensesSpringDataRepository;
	private ExpenseCustomRepository expenseCustomRepository;

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
	public void updateExpense(Expenses expense) {
		searchExpenseById(expense.getId());
		expensesSpringDataRepository.save(expense);
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
	public List<Expenses> searchExpenseByMonthAndYearAndDayAndEmail(String email, String month, String day,
			String year) {
		List<Expenses> expenses = expensesSpringDataRepository.findByMonthAndYearAndDayAndEmail(month, year, day,
				email);
		if (expenses.isEmpty()) {
			log.error("ACTION: searchExpenseByMonthAndYearAndDayAndEmail ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated");

		}

		return expenses;
	}

	@Override
	public List<Expenses> searchExpenseByMonthAndYearAndEmailAndCategory(String email, String month, String year,
			String category) {
		List<Expenses> expenses = expensesSpringDataRepository.findByMonthAndYearAndEmailAndCategory(month, year, email,
				category);
		if (expenses.isEmpty()) {
			log.error("ACTION: searchExpenseByMonthAndYearAndEmailAndCategory ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated");

		}

		return expenses;
	}

	public List<Expenses> searchExpenseByMonthAndYearAndDayAndEmailAndCategory(String email, String month, String day,
			String year, String category) {
		List<Expenses> expenses = expensesSpringDataRepository.findByMonthAndYearAndDayAndEmailAndCategory(month, year,
				day, email, category);
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
