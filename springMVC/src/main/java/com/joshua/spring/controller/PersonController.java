package com.joshua.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joshua.spring.bo.PersonBO;
import com.joshua.spring.model.Person;

@Controller
public class PersonController {

	@Autowired
	private PersonBO personBO;
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personBO.listPersons());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		if(p.getOid() == null){
			//new person, add it
			this.personBO.addPerson(p);
		}else{
			//existing person, call update
			this.personBO.updatePerson(p);
		}
		return "redirect:/persons";
	}
	
	@RequestMapping("/remove/{oid}")
    public String removePerson(@PathVariable("oid") Long oid){
        this.personBO.removePerson(oid);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{oid}")
    public String editPerson(@PathVariable("oid") Long oid, Model model) {
        model.addAttribute("person", this.personBO.getPersonById(oid));
        model.addAttribute("listPersons", this.personBO.listPersons());
        return "person";
    }
}
