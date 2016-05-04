package org.jaya.service.impl;

import java.util.List;

import org.jaya.dao.PersonDAO;
import org.jaya.model.Person;
import org.jaya.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;
	
	public void setPersonDAO(PersonDAO personDAO){
		this.personDAO=personDAO;
	}
	
	@Override
	@Transactional
	public void addPerson(Person person) {
		personDAO.addPerson(person);
		
	}

	@Override
	@Transactional
	public void updatePerson(Person person) {
		this.personDAO.updatePerson(person);
	}

	@Override
	@Transactional
	public void removePerson(int idPerson) {
		this.personDAO.removePerson(idPerson);
	}

	@Override
	@Transactional
	public Person getPersonById(int idPerson) {
		
		return this.personDAO.getPerson(idPerson);
	}

	@Override
	@Transactional
	public List<Person> listPerson() {
		
		return this.personDAO.listPerson();
	}

}
