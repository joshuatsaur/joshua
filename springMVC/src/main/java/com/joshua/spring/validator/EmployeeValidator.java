package com.joshua.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.joshua.spring.model.Employee;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> claz) {
		return Employee.class.isAssignableFrom(claz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
		final Employee emp = (Employee) target;
		if(emp.getId() <=0){
			errors.rejectValue("id", "negativeValue", new Object[] {"id"}, null);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "createdDate", "createdDate.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.required");
	}

}
