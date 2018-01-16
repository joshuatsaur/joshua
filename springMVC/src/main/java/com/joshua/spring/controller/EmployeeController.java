package com.joshua.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joshua.spring.model.Employee;
import com.joshua.spring.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		if (binder.getTarget().getClass().isAssignableFrom(Employee.class)) {
			EmployeeValidator validator = new EmployeeValidator();
			binder.setValidator(validator);
		}
	}

	// Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	Integer id = 0;

	private Integer generateId() {
		return ++id;
	}
	
	@RequestMapping(value = "/rest/emp/dummy", method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		Integer id = generateId();
		emp.setId(id);
		emp.setName("Dummy" + id);
		emp.setCreatedDate(new Date());
		empData.put(id, emp);
		return emp;
	}

	@RequestMapping(value = "/rest/emp/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID=" + empId);

		return empData.get(empId);
	}

	@RequestMapping(value = "/rest/emps", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {
		logger.info("Start getAllEmployees.");
		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = empData.keySet();
		for (Integer i : empIdKeys) {
			emps.add(empData.get(i));
		}
		return emps;
	}

	@RequestMapping(value = "/rest/emp/create", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Start createEmployee.");
		emp.setCreatedDate(new Date());
		empData.put(emp.getId(), emp);
		return emp;
	}

	@RequestMapping(value = "/rest/emp/delete/{id}", method = RequestMethod.PUT)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}
	
	@RequestMapping(value = "/emp/maintain", method = RequestMethod.GET)
	public String saveEmployeePage(Model model) {
		logger.info("Returning empSave.jsp page");
		model.addAttribute("emp", new Employee());
		return "empSave";
	}

	@RequestMapping(value = "/emp/save", method = RequestMethod.POST)
	public String saveEmployeeAction(@ModelAttribute("emp") @Validated final Employee employee, final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasErrors()) {
			logger.info("Returning empSave.jsp page");
			return "empSave";
		}
		logger.info("Returning empSaveSuccess.jsp page");
		model.addAttribute("emp", employee);
		empData.put(employee.getId(), employee);
		return "empSaveSuccess";
	}
}
