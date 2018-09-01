package com.savethislittle.userinfo.repository.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.savethislittle.userinfo.repository.entity.User;
import com.savethislittle.userinfo.repository.exception.UserInfoRepositoryException;
import com.savethislittle.userinfo.repository.repository.customrepositories.UserInfoCustomRepository;
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

	@Override
	public User createUser(final User user) {
		if (userInfoCustomRepository.checkIfUserExist(user.getEmail()) == false) {
			return userInfoSpringDataRepository.save(user);
		} else
			log.error("ACTION: createUser ERROR => {}", "User ** " + user.getEmail() + " ** not created");
		throw new UserInfoRepositoryException("The user already exists");
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

}
