package com.joshua.spring.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.joshua.spring.validator.Phone;

public class Customer {
	@Size(min = 2, max = 10)
	private String name;
	@NotBlank
	@Email
	private String email;
	@NotNull
	@Min(value = 0)
	@Max(value = 50)
	private Integer age;
	@NotNull
	private Gender gender;
	@NotNull
	@Past //The annotated element must be a date in the past
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date birthday;
	@Phone
	private String phone;
	
	public enum Gender {
		MALE , FEMALE
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(final Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(final Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}
}
