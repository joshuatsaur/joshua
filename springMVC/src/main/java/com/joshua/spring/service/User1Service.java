package com.joshua.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joshua.spring.model.User;

public class User1Service implements UserInterface {
	private Logger logger = LoggerFactory.getLogger(User1Service.class);

	@Override
	public void getName(User user) {
		logger.info("xxxxxxxx");
	}

}
