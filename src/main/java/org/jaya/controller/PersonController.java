package org.jaya.controller;

import org.jaya.model.Person;
import org.jaya.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {

	private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService=ps;
	}
	
	@RequestMapping(value="/persons", method=RequestMethod.GET)
	public String listPerson(Model model){
		model.addAttribute("person", new Person());
		model.addAttribute("personList", this.personService.listPerson());
		return "persons";
	}
	
	public String addPerson(@ModelAttribute("person") Person person){
		if(person.getId() == 0 ){
			this.personService.addPerson(person);
		}else{
			this.personService.updatePerson(person);
		}
		return "redirect:/persons";
	}
	
	
	
}
