package com.savethislittle.userinfo.repository.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.service.ExpensesService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class ExpenseController {

	private ExpensesService expensesService;

	@PostMapping("/expenses")
	public void createExpense(@Valid @RequestBody Expenses expense) {
		log.info("ACTION: createExpense INPUT: => {}", " NOTE: " + expense.getNote() + " USER: " + expense.getEmail());
		expensesService.createExpense(expense);
		log.info("ACTION: createExpense OUTPUT: => {}", "Expense created");
	}

	@PutMapping("/expenses")
	public ResponseEntity<Void> updateExpenses(@Valid @RequestBody Expenses expense) {
		log.info("ACTION: updateExpenses INPUT: => {}",
				" NOTE: " + expense.getNote() + "| USER: " + expense.getEmail());
		expensesService.updateExpense(expense);
		log.info("ACTION: updateExpenses OUTPUT: => {}", "expense updated");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/expenses/{id}")
	public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
		log.info("ACTION: deleteExpense INPUT: => {}", "EXPENSE ID: " + id);
		expensesService.deleteExpense(id);
		log.info("ACTION: deleteExpense OUTPUT: => {}", "Expense deleted");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/* SECTION TO RETURN EXPENSES FILTERED BY CATEGORIES, DATES OR BOTH */
	@GetMapping("/expenses/{email}/{category}")
	public ResponseEntity<List<Expenses>> findExpensesByCategoryAndMail(@PathVariable String category,
			@PathVariable String email) {
		log.info("ACTION: findExpensesByCategory INPUT: => {}", category, email);
		List<Expenses> expenses = expensesService.searchExpenseByCategoryAndMail(category, email);
		log.info("ACTION: findExpensesByCategory OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/expenses/{email}/{category}/{year}")
	public ResponseEntity<List<Expenses>> findExpensesByCategoryAndMailAndYear(@PathVariable String category,
			@PathVariable String email, @PathVariable String year) {
		log.info("ACTION: findExpensesByCategory INPUT: => {}", category, email);
		List<Expenses> expenses = expensesService.searchExpenseByCategoryAndMailAndYear(category, email, year);
		log.info("ACTION: findExpensesByCategory OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/expenses/{email}/{category}/{year}/{month}")
	public ResponseEntity<List<Expenses>> searchExpenseByMonthAndYearAndEmailAndCategory(@PathVariable String month,
			@PathVariable String year, @PathVariable String email, @PathVariable String category) {
		log.info("ACTION: searchExpenseByMonthAndYearAndEmailAndCategory INPUT: => {}", month, year, email, category);
		List<Expenses> expenses = expensesService.searchExpenseByMonthAndYearAndEmailAndCategory(email, month, year,
				category);
		log.info("ACTION: searchExpenseByMonthAndYearAndEmailAndCategory OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/expenses/{email}/{category}/{year}/{month}/{day}")
	public ResponseEntity<List<Expenses>> searchExpenseByMonthAndYearAndEmailAndCategory(@PathVariable String month,
			@PathVariable String year, @PathVariable String day, @PathVariable String email,
			@PathVariable String category) {
		log.info("ACTION: searchExpenseByMonthAndYearAndEmailAndCategory INPUT: => {}", month, year, day, email,
				category);
		List<Expenses> expenses = expensesService.searchExpenseByMonthAndYearAndDayAndEmailAndCategory(email, month,
				day, year, category);
		log.info("ACTION: searchExpenseByMonthAndYearAndEmailAndCategory OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}
	/* END: SECTION TO RETURN EXPENSES FILTERED BY CATEGORIES, DATES OR BOTH */

	/* SECTION TO RETURN ALL EXPENSES BY DATES */
	@GetMapping("/allexpenses/{email}")
	public ResponseEntity<List<Expenses>> findExpensesByEmail(@PathVariable String email) {
		log.info("ACTION: findExpensesByEmail INPUT: => {}", email);
		List<Expenses> expenses = expensesService.searchExpenseByEmail(email);
		log.info("ACTION: findExpensesByEmail OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/allexpenses/{email}/{year}")
	public ResponseEntity<List<Expenses>> searchExpenseByYearAndEmail(@PathVariable String email,
			@PathVariable String year) {
		log.info("ACTION: searchExpenseByYearAndEmail INPUT: => {}", year, email);
		List<Expenses> expenses = expensesService.searchExpenseByYearAndEmail(email, year);
		log.info("ACTION: searchExpenseByYearAndEmail OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/allexpenses/{email}/{year}/{month}")
	public ResponseEntity<List<Expenses>> searchExpenseByMonthAndYearAndEmail(@PathVariable String month,
			@PathVariable String year, @PathVariable String email) {
		log.info("ACTION: searchExpenseByMonthAndYearAndEmail INPUT: => {}", month, year, email);
		List<Expenses> expenses = expensesService.searchExpenseByMonthAndYearAndEmail(email, month, year);
		log.info("ACTION: searchExpenseByMonthAndYearAndEmail OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/allexpenses/{email}/{year}/{month}/{day}")
	public ResponseEntity<List<Expenses>> searchExpenseByMonthAndYearAndDayAndEmail(@PathVariable String month,
			@PathVariable String year, @PathVariable String day, @PathVariable String email) {
		log.info("ACTION: searchExpenseByMonthAndYearAndEmail INPUT: => {}", month, year, email, day);
		List<Expenses> expenses = expensesService.searchExpenseByMonthAndYearAndDayAndEmail(email, month, day, year);
		log.info("ACTION: searchExpenseByMonthAndYearAndEmail OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}
	/* END: SECTION TO RETURN ALL EXPENSES BY DATES */

}
