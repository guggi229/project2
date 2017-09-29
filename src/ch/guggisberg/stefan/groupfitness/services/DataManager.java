package ch.guggisberg.stefan.groupfitness.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.guggisberg.stefan.groupfitness.model.Tag;
import ch.guggisberg.stefan.groupfitness.model.Lessontyp;
import ch.guggisberg.stefan.groupfitness.model.User;

@Stateless
public class DataManager  {
	
	@PersistenceContext
	private  EntityManager em;
	
	public void save() {
		User u1 = new User("Stefan");
		em.persist(u1);
		
		Lessontyp l1 = new Lessontyp("Test");
		em.persist(l1);
		
		Tag tag = new Tag("Test");
		em.persist(tag);
		
		getTags();
		
	}
	
	@SuppressWarnings("unchecked")
	private void getTags() {
		Query query = em.createQuery("Select t FROM Tag t");
		List<Tag> tags = query.getResultList();
		for (Tag tag : tags) {
			System.out.println(tag.getTagName());
		}
	}

	public String getname() {
		System.out.println(em.find(User.class, 1L).getUserName());
		return "test";
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Tag> getTags(){
//		List<Tag> test = em.createNamedQuery("Tag.findAllTags").getResultList();
//		for (Tag tag : test) {
//			System.out.println(tag.getTagName());
//		}
//		return test;
//	}
	
}
