package ch.guggisberg.stefan.groupfitness.services;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;

import ch.guggisberg.stefan.groupfitness.model.Tag;
import ch.guggisberg.stefan.groupfitness.filters.LoginFilter;
import ch.guggisberg.stefan.groupfitness.model.Lessontyp;
import ch.guggisberg.stefan.groupfitness.model.User;

@Named
@RequestScoped
public class DataManager implements Serializable  {

	private static final long serialVersionUID = 332935220002211416L;
	private static Logger log = Logger.getLogger(DataManager.class);
	@PersistenceContext
	private  EntityManager em;
	@Resource
	private UserTransaction ut;
	
	
	
	private String tagName;


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
	
	// Tag Handling
	// =============
	
	public String addTag() {
		Tag tag = new Tag(tagName);
		try {
			ut.begin();
		} catch (NotSupportedException e) {
			e.printStackTrace();
			log.debug(e);
		} catch (SystemException e) {
			log.debug(e);
		}
		em.persist(tag);
		try {
			ut.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getTags();
		return "tagVerwaltung";
	}
	
	// Getter / Setter
	// ================
	
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
}
