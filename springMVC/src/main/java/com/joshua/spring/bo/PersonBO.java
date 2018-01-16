package com.joshua.spring.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joshua.spring.model.Person;
import com.joshua.spring.service.PersonDAO;

@Service("PersonBO")
@Transactional
public class PersonBO {
	@Autowired
	private PersonDAO personDAO;
	
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	public Person getPersonById(Long id) {
		return this.personDAO.getPersonById(id);
	}

	public void removePerson(Long id) {
		this.personDAO.removePerson(id);
	}
}
