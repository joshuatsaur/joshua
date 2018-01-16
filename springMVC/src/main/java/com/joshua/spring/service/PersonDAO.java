package com.joshua.spring.service;

import java.util.List;

import com.joshua.spring.model.Person;

public interface PersonDAO {
	public void addPerson(Person p);

	public void updatePerson(Person p);

	public List<Person> listPersons();

	public Person getPersonById(Long id);

	public void removePerson(Long id);

}
