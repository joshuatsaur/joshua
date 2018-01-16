package com.joshua.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joshua.spring.model.MyBean;
import com.joshua.spring.model.User;
import com.joshua.spring.service.MyAnnotatedBean;
import com.joshua.spring.service.UserInterface;

@Controller
@Scope("request")
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
    private MyBean myBean;
	@Autowired
	private MyAnnotatedBean myAnnotatedBean;
	@Autowired
	@Qualifier("user1Service")
	private UserInterface service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("MyBean hashcode= {}.", myBean.hashCode());
		logger.info("myAnnotatedBean hashcode= {}.", myAnnotatedBean.hashCode());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,	DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) {
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String login(@Validated User user, Model model) {
		service.getName(user);
		model.addAttribute("userName", user.getUserName());
		return "user";
	}
}
