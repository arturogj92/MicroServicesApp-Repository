package com.savethislittle.userinfo.repository.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public void createUser(@Valid @RequestBody User user) {
		// log.info("createEmployee dataIn => {}", employee);
		// User userInserted = userInfoService.createUser(user);
		userInfoService.createUser(user);
		// URI location =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userInserted.getId()).toUri();
		// /return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/expense")
	public void createExpense(@Valid @RequestBody Expenses expense) {
		// log.info("createEmployee dataIn => {}", employee);
		// User userInserted = userInfoService.createUser(user);
		userInfoService.createExpense(expense);
		// URI location =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userInserted.getId()).toUri();
		// /return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping("/expenses/{id}")
	public ResponseEntity<List<Expenses>> findExpensesById (@PathVariable Long id) {
		
		List<Expenses> expenses = userInfoService.searchExpenseById(id);
		//log.info("findById dataOut => employees: {}", employees);
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}
	
	

}
