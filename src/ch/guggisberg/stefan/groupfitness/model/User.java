package ch.guggisberg.stefan.groupfitness.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
@Named
@RequestScoped
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Userid")
	private Long id;

	@Column(name="UserName")
	private String  userName;
	
	@Column(name="UserEmail")
	private String  userEmail;
	
	@Column(name="UserLang")
	private String  userLang;
	

	
	// Konstruktor für Hibernate
	public User() {

	}
	public User( String name) {
		this.userName =name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserLang() {
		return userLang;
	}
	public void setUserLang(String userLang) {
		this.userLang = userLang;
	}


}
