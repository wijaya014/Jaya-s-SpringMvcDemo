package org.jaya.service;

import java.util.List;
import org.jaya.model.Person;

public interface PersonService {
	
	public void addPerson(Person person);
	public void updatePerson(Person person);
	public void removePerson(int idPerson);
	public Person getPersonById(int idPerson);
	public List<Person> listPerson();
}
