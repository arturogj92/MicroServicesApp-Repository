package com.savethislittle.userinfo.repository.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.entity.SumAmountExpensesMonthYear;
import com.savethislittle.userinfo.repository.entity.SumAmountExpensesYear;
import com.savethislittle.userinfo.repository.entity.User;
import com.savethislittle.userinfo.repository.service.UserInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class UserInfoController {

	//TODO => DIVIDIR EN Varios controladores
	
	/*
	 * Controller para user
	 * Controller para expenses normales
	 * Controller para Sumamounts
	 * 
	 * Hacer tambien 3 servicios, 1 por cada 1
	 * Adaptar el microservicio de moneyinfo
	 * 
	 * microserv emails
	 * microserv previsiones
	 * microserv serv configuracion
	 * sleuth
	 * elk
	 * zuul
	 * seguridad
	 * docker
	 * 
	 */
	
	
	private UserInfoService userInfoService;

	@PostMapping("/user")
	public ResponseEntity<Void> createUser(@Valid @RequestBody User user) {
		log.info("ACTION: createUser INPUT => {}", user.getEmail());
		User userInserted = userInfoService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userInserted.getId()).toUri();
		log.info("ACTION: createUser OUTPUT => {}", "User created");
		return ResponseEntity.created(location).build();
	}

	@PostMapping("/expenses")
	public void createExpense(@Valid @RequestBody Expenses expense) {
		log.info("ACTION: createExpense INPUT: => {}", " NOTE: " + expense.getNote() + " USER: " + expense.getEmail());
		userInfoService.createExpense(expense);
		log.info("ACTION: createExpense OUTPUT: => {}", "Expense created");
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		log.info("ACTION: getAllUsers INPUT: => {}");
		List<User> usersList = userInfoService.findAll();
		log.info("ACTION: getAllUsers OUTPUT => users size: {}", usersList.size());
		return new ResponseEntity<>(usersList, HttpStatus.OK);

	}

	@GetMapping("/userid/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
		Optional<User> userById = userInfoService.getUserById(id);
		return new ResponseEntity<>(userById, HttpStatus.OK);
	}

	@GetMapping("/user/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		log.info("ACTION: getUserByEmail INPUT: => {}", email);
		User user = userInfoService.getUserByEmail(email);
		log.info("ACTION: getUserByEmail OUTPUT => user: {}",
				" USERNAME: " + user.getUserName() + " EMAIL: " + user.getEmail());
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	
	/*SECTION TO RETURN EXPENSES FILTERED BY CATEGORIES, DATES OR BOTH */
	@GetMapping("/expenses/{email}/{category}")
	public ResponseEntity<List<Expenses>> findExpensesByCategoryAndMail(@PathVariable String category,
			@PathVariable String email) {
		log.info("ACTION: findExpensesByCategory INPUT: => {}", category, email);
		List<Expenses> expenses = userInfoService.searchExpenseByCategoryAndMail(category, email);
		log.info("ACTION: findExpensesByCategory OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}
	
	@GetMapping("/expenses/{email}/{category}/{year}")
	public ResponseEntity<List<Expenses>> findExpensesByCategoryAndMailAndYear(@PathVariable String category,
			@PathVariable String email, @PathVariable String year) {
		log.info("ACTION: findExpensesByCategory INPUT: => {}", category, email);
		List<Expenses> expenses = userInfoService.searchExpenseByCategoryAndMailAndYear(category, email, year);
		log.info("ACTION: findExpensesByCategory OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	
	@GetMapping("/expenses/{email}/{category}/{year}/{month}")
	public ResponseEntity<List<Expenses>> searchExpenseByMonthAndYearAndEmailAndCategory(@PathVariable String month,
			@PathVariable String year, @PathVariable String email, @PathVariable String category) {
		log.info("ACTION: searchExpenseByMonthAndYearAndEmailAndCategory INPUT: => {}", month, year, email, category);
		List<Expenses> expenses = userInfoService.searchExpenseByMonthAndYearAndEmailAndCategory(email, month, year,
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
		List<Expenses> expenses = userInfoService.searchExpenseByMonthAndYearAndDayAndEmailAndCategory(email, month,
				day, year, category);
		log.info("ACTION: searchExpenseByMonthAndYearAndEmailAndCategory OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}
	/* END: SECTION TO RETURN EXPENSES FILTERED BY CATEGORIES, DATES OR BOTH */
	
	

	/* SECTION TO RETURN ALL EXPENSES BY DATES */
	@GetMapping("/allexpenses/{email}")
	public ResponseEntity<List<Expenses>> findExpensesByEmail(@PathVariable String email) {
		log.info("ACTION: findExpensesByEmail INPUT: => {}", email);
		List<Expenses> expenses = userInfoService.searchExpenseByEmail(email);
		log.info("ACTION: findExpensesByEmail OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/allexpenses/{email}/{year}")
	public ResponseEntity<List<Expenses>> searchExpenseByYearAndEmail(@PathVariable String email,
			@PathVariable String year) {
		log.info("ACTION: searchExpenseByYearAndEmail INPUT: => {}", year, email);
		List<Expenses> expenses = userInfoService.searchExpenseByYearAndEmail(email, year);
		log.info("ACTION: searchExpenseByYearAndEmail OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/allexpenses/{email}/{year}/{month}")
	public ResponseEntity<List<Expenses>> searchExpenseByMonthAndYearAndEmail(@PathVariable String month,
			@PathVariable String year, @PathVariable String email) {
		log.info("ACTION: searchExpenseByMonthAndYearAndEmail INPUT: => {}", month, year, email);
		List<Expenses> expenses = userInfoService.searchExpenseByMonthAndYearAndEmail(email, month, year);
		log.info("ACTION: searchExpenseByMonthAndYearAndEmail OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/allexpenses/{email}/{year}/{month}/{day}")
	public ResponseEntity<List<Expenses>> searchExpenseByMonthAndYearAndDayAndEmail(@PathVariable String month,
			@PathVariable String year, @PathVariable String day, @PathVariable String email) {
		log.info("ACTION: searchExpenseByMonthAndYearAndEmail INPUT: => {}", month, year, email, day);
		List<Expenses> expenses = userInfoService.searchExpenseByMonthAndYearAndDayAndEmail(email, month, day, year);
		log.info("ACTION: searchExpenseByMonthAndYearAndEmail OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}
	/* END: SECTION TO RETURN ALL EXPENSES BY DATES */	
	
	
	
	
	
	// Returns: The amount expensed in categories in the year
	@GetMapping("/sumamountexpenses/{email}/{year}")
	public ResponseEntity<List<SumAmountExpensesYear>> getTotalAmountCategory(@PathVariable String email,
			@PathVariable String year) {
		log.info("ACTION: getTotalAmountCategory INPUT: => {}", email);
		List<SumAmountExpensesYear> expenses = userInfoService.getTotalAmountExpensedInCategoryByYear(email, year);
		log.info("ACTION: getTotalAmountCategory OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}
	
	// Returns: The amount expensed in each categories in the month and year
	@GetMapping("/sumamountexpenses/{email}/{year}/{month}")
	public ResponseEntity<List<SumAmountExpensesMonthYear>> getTotalAmountCategoryByMonthAndYear(@PathVariable String email,
			@PathVariable String month, @PathVariable String year) {
		log.info("ACTION: getTotalAmountCategoryByMonthAndYear INPUT: => {}", email);
		List<SumAmountExpensesMonthYear> expenses = userInfoService.getTotalAmountExpensedInCategoryByMonthAndYear(email, month,
				year);
		log.info("ACTION: getTotalAmountCategoryByMonthAndYear OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}



	@PutMapping("/user")
	public ResponseEntity<Void> updateUser(@Valid @RequestBody User user) {
		log.info("ACTION: updateUser INPUT: => {}", "ID to be UPDATED " + user.getEmail());
		userInfoService.updateUser(user);
		log.info("ACTION: updateUser OUTPUT => user updated: {}" + user.getEmail());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/expenses")
	public ResponseEntity<Void> updateExpenses(@Valid @RequestBody Expenses expense) {
		log.info("ACTION: updateExpenses INPUT: => {}",
				" NOTE: " + expense.getNote() + "| USER: " + expense.getEmail());
		userInfoService.updateExpense(expense);
		log.info("ACTION: updateExpenses OUTPUT: => {}", "expense updated");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/expenses/{id}")
	public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
		log.info("ACTION: deleteExpense INPUT: => {}", "EXPENSE ID: " + id);
		userInfoService.deleteExpense(id);
		log.info("ACTION: deleteExpense OUTPUT: => {}", "Expense deleted");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/user/{email}")
	public ResponseEntity<Void> deleteUserByEmail(@PathVariable String email) {
		log.info("ACTION: deleteUserByEmail INPUT: => {}", "USER EMAIL: " + email);
		userInfoService.deleteUserByEmail(email);
		log.info("ACTION: deleteUserByEmail OUTPUT: => {}", "User deleted");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
