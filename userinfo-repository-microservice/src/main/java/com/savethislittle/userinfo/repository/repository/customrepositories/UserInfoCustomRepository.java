package com.savethislittle.userinfo.repository.repository.customrepositories;

import java.util.List;

import com.savethislittle.userinfo.repository.entity.User;

public interface UserInfoCustomRepository {

	public boolean checkIfUserExist(String email);
	
	public List<User> findUserByEmail(String email);
	

}
