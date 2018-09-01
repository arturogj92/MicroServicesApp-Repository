package com.savethislittle.userinfo.repository.service;

import java.util.List;
import java.util.Optional;

import com.savethislittle.userinfo.repository.entity.User;

public interface UserInfoService {

	public User createUser(final User user);

	public void updateUser(User user);

	public void deleteUserByEmail(String email);

	public User getUserByEmail(String email);

	public boolean checkIfUserExists(String email);

	public List<User> findAll();

	public Optional<User> getUserById(Long id);

}
