package ch.guggisberg.stefan.groupfitness.services;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ch.guggisberg.stefan.groupfitness.model.User;




/**
 * 
 * @author guggi229
 * 
 * This bean handle the login.
 * NON INERIT!
 *
 */
@ManagedBean(name="loginBean")
@SessionScoped
public final class LoginBean implements Serializable  {
	private static final long serialVersionUID = -3070846601605974845L;
	private static Logger log = Logger.getLogger(LoginBean.class);

	// DB Verbindung
	@PersistenceContext
	private EntityManager em;

	// Logindaten
	private String  email;
	private String pass;
	private boolean loggedIn;

	//User
	@Inject
	private User user;
	
	// Sprache Einstellung
	private Locale locale;

	/**
	 * Check the login Data
	 * @return
	 */
	public String checkLogin(){
		Integer result=0;
		Query query = em.createNativeQuery("Select Userid from groupfitness.user u WHERE u.UserEmail='" + email + "' AND u.UserPassword='" + pass + "'");
		try {
			result =  (Integer) query.getSingleResult();
			if (result.intValue()>0){
				user = em.find(User.class, result.longValue());
				log.info("User mit Email " + email + "hat korrekt eingeloggt");
				loggedIn=true;
				return "secured/welcome";
			}
		} catch (NoResultException e) {
			loggedIn=false;
			log.info("User mit Email " + email + "hat ist nicht eingeloggt");
		}
		return "login";

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

	public boolean isLogged(){
		return loggedIn;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
