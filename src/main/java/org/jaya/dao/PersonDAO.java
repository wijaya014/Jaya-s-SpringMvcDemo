package org.jaya.dao;

import java.util.List;
import org.jaya.model.Person;

public interface PersonDAO {
	public void addPerson(Person person);
	public void updatePerson(Person person);
	public Person getPerson(int idPerson);
	public void removePerson(int idPerson);
	public List<Person> listPerson();
}
