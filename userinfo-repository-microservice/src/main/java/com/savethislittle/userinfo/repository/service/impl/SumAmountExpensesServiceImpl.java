package com.savethislittle.userinfo.repository.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.savethislittle.userinfo.repository.entity.SumAmountExpensesMonthYear;
import com.savethislittle.userinfo.repository.entity.SumAmountExpensesYear;
import com.savethislittle.userinfo.repository.exception.UserInfoRepositoryException;
import com.savethislittle.userinfo.repository.repository.springdatarepositories.SumAmountExpensesMonthYearSpringDataRepository;
import com.savethislittle.userinfo.repository.repository.springdatarepositories.SumAmountExpensesYearSpringDataRepository;
import com.savethislittle.userinfo.repository.service.SumAmountExpensesService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class SumAmountExpensesServiceImpl implements SumAmountExpensesService {

	private SumAmountExpensesMonthYearSpringDataRepository sumAmountExpensesMonthYearSpringDataRepository;
	private SumAmountExpensesYearSpringDataRepository sumAmountExpensesYearSpringDataRepository;

	@Override
	public List<SumAmountExpensesMonthYear> getTotalAmountExpensedInCategoryByMonthAndYear(String email, String month,
			String year) {
		List<SumAmountExpensesMonthYear> expenses = sumAmountExpensesMonthYearSpringDataRepository
				.findByEmailAndMonthAndYear(email, month, year);
		if (expenses.isEmpty()) {
			log.error("ACTION: getTotalAmountExpensedInCategoryByMonthAndYear ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated");
		}

		return expenses;
	}

	@Override
	public List<SumAmountExpensesYear> getTotalAmountExpensedInCategoryByYear(String email, String year) {
		List<SumAmountExpensesYear> expenses = sumAmountExpensesYearSpringDataRepository.findByEmailAndYear(email,
				year);
		if (expenses.isEmpty()) {
			log.error("ACTION: getTotalAmountExpensedInCategoryByYear ERROR => expensessize(): {}",
					"The user doesn't have expenses asociated");
			throw new UserInfoRepositoryException("User doesn't have expenses asociated");
		}

		return expenses;
	}

}
