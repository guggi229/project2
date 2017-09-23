package ch.guggisberg.stefan.groupfitness.services;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable  {
	private static final long serialVersionUID = -3070846601605974845L;
	// Logindaten
	private String  email;
	private String pass;
	private boolean loggedIn;
	
	public String checkLogin(){
		
	System.out.println("check");
	
	return null;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		System.out.println("*******************************");
		System.out.println("*******************************");
		System.out.println("*******************************");
		System.out.println("*******************************");
		System.out.println("*******************************");
		System.out.println("*******************************");
		System.out.println(email);
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
	

}
