package com.savethislittle.userinfo.repository.repository;

import java.util.List;

import com.savethislittle.userinfo.repository.entity.User;

public interface UserInfoCustomRepository {

	public User checkIfUserExist(String email);
	

}
