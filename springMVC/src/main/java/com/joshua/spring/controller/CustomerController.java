package com.joshua.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joshua.spring.model.Customer;

@Controller
public class CustomerController {
	private Logger logger = LoggerFactory.getLogger(CustomerController.class);
	private Map<String, Customer> customers;

	@RequestMapping(value = "/cust/maintain", method = RequestMethod.GET)
	public String saveCustomerPage(final Model model) {
		logger.info("Returning custSave.jsp page");
		model.addAttribute("customer", new Customer());
		model.addAttribute("urlParm", "joshua");
		return "custSave";
	}

	@RequestMapping(value = "/cust/save/{parm}", method = RequestMethod.POST)
	public String saveCustomerAction(@PathVariable(value="parm") final String parm, @ModelAttribute(value="customer") @Valid final Customer customer, final BindingResult bindingResult, final Model model) {
		logger.info("url parm = {} " , parm);
		if (bindingResult.hasErrors()) {
			logger.info("Returning custSave.jsp page");
			return "custSave";
		}
		logger.info("Returning custSaveSuccess.jsp page");
		model.addAttribute("customer", customer);
		getCustomers().put(customer.getEmail(), customer);
		return "custSaveSuccess";
	}
	
	private Map<String, Customer> getCustomers() {
		if (null == customers) {
			customers = new HashMap<String, Customer>();
		}
		return customers;
	}

}
