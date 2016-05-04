package org.jaya.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jaya.dao.PersonDAO;
import org.jaya.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private static final Logger logger=LoggerFactory.getLogger(PersonDAO.class);
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory=sf;
	}
	
	@Override
	public void addPerson(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(person);
		logger.info("Person Save Successfully, Person Detail "+person);
	}

	@Override
	public void updatePerson(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(person);
		logger.info("Person update succesfully, person detail "+person);
		
	}

	@Override
	public Person getPerson(int idPerson) {
		Session session =  this.sessionFactory.getCurrentSession();
		Person person = (Person) session.get(Person.class, idPerson);
		return person;
	}

	@Override
	public void removePerson(int idPerson) {
		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, idPerson);
		if(person != null){
			session.delete(person);
		}
		logger.info("Person succesfully delete");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPerson() {
		List<Person> personList = this.sessionFactory.getCurrentSession().createQuery("from Person").list();
		for(Person p : personList){
			logger.info("person "+p);
		}
		return personList;
	}

}
