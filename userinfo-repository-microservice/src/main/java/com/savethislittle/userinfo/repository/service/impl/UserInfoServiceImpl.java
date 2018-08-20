package com.savethislittle.userinfo.repository.service.impl;

import java.util.List;

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
		// return userInfoSpringDataRepository.save(user);
		if (checkIfUserExists(user.getEmail()) == false) {
			userInfoSpringDataRepository.save(user);
		}

		return null;
	}

	// mirar para insertar lista de gastos
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
		if (expenses.size() == 0) {
			throw new UserInfoRepositoryException("The user not exist");
		}
		// log.info("simpleSearch dataOut => employees.size(): {}", expenses.size());
		return expenses;
	}

	@Override
	public boolean checkIfUserExists(String email) {
		// TODO Auto-generated method stub

		User usercheck = userInfoCustomRepository.checkIfUserExist(email);
		String message;

		if (usercheck != null) {
			message = "The user already exists";
			throw new UserInfoRepositoryException(message);

		}

		return false;
	}

	//
	// private void checkIsEmployeeExist(Employee employee) {
	// List<Employee> employees =
	// salarySearchRepository.checkIsEmployeeExist(employee.getDni(),
	// employee.getEmail(), employee.getPhone());
	// List<String> errors = new ArrayList<>();
	//
	// if(employees != null && !employees.isEmpty()) {
	// log.error("Exsist {} employees with unique data", employees.size());
	// if(employees.get(0).getDni().equals(employee.getDni())) {
	// log.error("The dni already exist in the system");
	// errors.add("The dni already exist in the system");
	// }
	// if(employees.get(0).getEmail().equals(employee.getEmail())) {
	// log.error("The email already exist in the system");
	// errors.add("The email already exist in the system");
	// }
	// if(employees.get(0).getPhone().equals(employee.getPhone())) {
	// log.error("The phone already exist in the system");
	// errors.add("The phone already exist in the system");
	// }
	// }
	//
	// if(!errors.isEmpty()) {
	// throw new SalaryRepositoryServiceException(errors);
	// }
	// }

}
