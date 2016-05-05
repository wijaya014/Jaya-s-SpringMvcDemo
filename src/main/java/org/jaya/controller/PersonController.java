package org.jaya.controller;

import org.jaya.model.Person;
import org.jaya.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/person", method=RequestMethod.GET)
	public String listPerson(Model model){
		model.addAttribute("person", new Person());
		model.addAttribute("personList", this.personService.listPerson());
		return "person";
	}
	
	@RequestMapping(value="/person/add", method=RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person person){
		if(person.getId() == 0 ){
			this.personService.addPerson(person);
		}else{
			this.personService.updatePerson(person);
		}
		return "redirect:/person";
	}
	
	@RequestMapping(value="/remove/{id}")
	public String removePerson(@PathVariable("id") int id){
		this.personService.removePerson(id);
		return "redirect:/person";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model){
		model.addAttribute("person",this.personService.getPersonById(id));
		model.addAttribute("listPerson",this.personService.listPerson());
		return "person";
	}
	
	
	
}
