package ch.guggisberg.stefan.groupfitness.services;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;



/**
 * 
 * @author guggi229
 * 
 * This bean handle the login.
 *
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable  {
	private static final long serialVersionUID = -3070846601605974845L;
	
	// DB Verbindung
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	
	// Logindaten
	private String  email;
	private String pass;
	private boolean loggedIn;
	
	/**
	 * Check the login Data
	 * @return
	 */
	public void checkLogin(){
		Integer result=0;
		Query query = em.createNativeQuery("Select Userid from groupfitness.user u WHERE u.UserEmail='" + email + "' AND u.UserPassword='" + pass + "'");
		//Query query = em.createNativeQuery("Select Userid from groupfitness.user u WHERE UserEmail='stefan@gmx.ch' AND u.UserPassword='123';");

		System.out.println("check");
		try {
			result =  (Integer) query.getSingleResult();
			System.out.println("query ausgeführt");
			if (result.intValue()>0){
				//user = em.find(User2.class, result.longValue());
				System.out.println("Logged in");
				loggedIn=true;
			
			}
		} catch (NoResultException e) {
			loggedIn=false;
			System.out.println("not logged in");
		
		}

		
	}
	
	// Getter and Setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String getPass() {
		return pass;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	

}
