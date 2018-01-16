package com.joshua.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joshua.spring.model.User;

public class UserService implements UserInterface {
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Override
	public void getName(User user) {
		logger.info(user.getUserName());
	}

}
