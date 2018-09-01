package com.savethislittle.userinfo.repository.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.savethislittle.userinfo.repository.entity.SumAmountExpensesMonthYear;
import com.savethislittle.userinfo.repository.entity.SumAmountExpensesYear;
import com.savethislittle.userinfo.repository.service.SumAmountExpensesService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class SumAmountExpensesController {

	private SumAmountExpensesService sumAmountExpensesService;

	// Returns: The amount expensed in categories in the year
	@GetMapping("/sumamountexpenses/{email}/{year}")
	public ResponseEntity<List<SumAmountExpensesYear>> getTotalSumExpensedInYear(@PathVariable String email,
			@PathVariable String year) {
		log.info("ACTION: GetTotalSumExpensedInYear INPUT: => {}", email);
		List<SumAmountExpensesYear> expenses = sumAmountExpensesService.getTotalAmountExpensedInCategoryByYear(email,
				year);
		log.info("ACTION: GetTotalSumExpensedInYear OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	// Returns: The amount expensed in each categories in the month and year
	@GetMapping("/sumamountexpenses/{email}/{year}/{month}")
	public ResponseEntity<List<SumAmountExpensesMonthYear>> getTotalSumExpensedInYearAndMonth(
			@PathVariable String email, @PathVariable String month, @PathVariable String year) {
		log.info("ACTION: getTotalSumExpensedInYearAndMonth INPUT: => {}", email);
		List<SumAmountExpensesMonthYear> expenses = sumAmountExpensesService
				.getTotalAmountExpensedInCategoryByMonthAndYear(email, month, year);
		log.info("ACTION: getTotalSumExpensedInYearAndMonth OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

}
