
package com.savethislittle.userinfo.repository.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserInfoRepositoryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserInfoRepositoryException(String message) {
		super(message);
	}

}