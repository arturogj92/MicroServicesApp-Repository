package com.savethislittle.userinfo.repository.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.entity.User;
import com.savethislittle.userinfo.repository.service.UserInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class UserInfoController {

	
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

	@GetMapping("/user/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		log.info("ACTION: getUserByEmail INPUT: => {}", email);
		User user = userInfoService.getUserByEmail(email);
		log.info("ACTION: getUserByEmail OUTPUT => user: {}"," USERNAME: " + user.getUserName()+ " EMAIL: " + user.getEmail());
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	@PostMapping("/expenses")
	public void createExpense(@Valid @RequestBody Expenses expense) {
		log.info("ACTION: createExpense INPUT: => {}", " NOTE: " + expense.getNote() + " USER: " + expense.getEmail());
		userInfoService.createExpense(expense);
		log.info("ACTION: createExpense OUTPUT: => {}", "Expense created");
	}

	@GetMapping("/expenses/{email}")
	public ResponseEntity<List<Expenses>> findExpensesByEmail(@PathVariable String email) {
		log.info("ACTION: findExpensesByEmail INPUT: => {}", email);
		List<Expenses> expenses = userInfoService.searchExpenseByEmail(email);
		log.info("ACTION: findExpensesByEmail OUTPUT => expenses size: {}", expenses.size());
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		log.info("ACTION: getAllUsers INPUT: => {}");
		List<User> usersList = userInfoService.findAll();
		log.info("ACTION: getAllUsers OUTPUT => users size: {}", usersList.size());
		return new ResponseEntity<>(usersList, HttpStatus.OK);

	}

	@PutMapping("/user")
	public ResponseEntity<Void> updateUser(@Valid @RequestBody User user) {
		log.info("ACTION: updateUser INPUT: => {}","ID to be UPDATED "+ user.getEmail());
		userInfoService.updateUser(user);
		log.info("ACTION: updateUser OUTPUT => user updated: {}"+ user.getEmail());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/expenses")
	public ResponseEntity<Void> updateExpenses(@Valid @RequestBody Expenses expense) {
		log.info("ACTION: updateExpenses INPUT: => {}"," NOTE: " + expense.getNote() + "| USER: " + expense.getEmail());
		userInfoService.updateExpense(expense);
		log.info("ACTION: updateExpenses OUTPUT: => {}", "expense updated");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/expenses/{id}")
	public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
		log.info("ACTION: deleteExpense INPUT: => {}","EXPENSE ID: "+ id);
		userInfoService.deleteExpense(id);
		log.info("ACTION: deleteExpense OUTPUT: => {}","Expense deleted");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/user/{email}")
	public ResponseEntity<Void> deleteUserByEmail(@PathVariable String email) {
		log.info("ACTION: deleteUserByEmail INPUT: => {}","USER EMAIL: "+ email);
		userInfoService.deleteUserByEmail(email);
		log.info("ACTION: deleteUserByEmail OUTPUT: => {}","User deleted");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
