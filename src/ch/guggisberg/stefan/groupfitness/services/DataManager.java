package ch.guggisberg.stefan.groupfitness.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import ch.guggisberg.stefan.groupfitness.model.User;

@Stateless
public class DataManager  {
	
	@PersistenceContext
	private  EntityManager em;
	
	public void save() {
		User u1 = new User("Stefan");
		em.persist(u1);
	}
	
	public String getname() {
		System.out.println(em.find(User.class, 1L).getUserName());
		return "test";
	}
	
	
}
